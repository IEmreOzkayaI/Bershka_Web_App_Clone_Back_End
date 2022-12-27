package pure.bershka.business.concretes;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.business.abstracts.OrderService;
import pure.bershka.core.utilities.result.*;
import pure.bershka.dataAccess.abstracts.*;
import pure.bershka.entities.concretes.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderManager implements OrderService {
    private OrderDao orderDao;
    private CustomerDao customerDao;
    private StockDao stockDao;
    private ProductDao productDao;
    private SizeDao sizeDao;
    private OrderDetailDao orderDetailDao;
    private DiscountCodeDao discountCodeDao;
    private LocationDao locationDao;

    @Autowired
    public OrderManager(OrderDao orderDao, CustomerDao customerDao,
                        StockDao stockDao,ProductDao productDao,
                        SizeDao sizeDao,OrderDetailDao orderDetailDao,
                        DiscountCodeDao discountCodeDao, LocationDao locationDao) {
        this.orderDao = orderDao;
        this.customerDao = customerDao;
        this.stockDao = stockDao;
        this.productDao = productDao;
        this.sizeDao = sizeDao;
        this.orderDetailDao = orderDetailDao;
        this.discountCodeDao = discountCodeDao;
        this.locationDao = locationDao;
    }



    //FOR ADMIN
    @Override
    public DataResult<List<Order>> getAllOrdersForAdmin() {
        return new SuccessDataResult<List<Order>>(this.orderDao.findAll());
    }
    @Override
    public Result deleteOrder(int orderId) {
        Order deletedOrder = this.orderDao.findById(orderId).get();
        this.orderDao.delete(deletedOrder);
        return new Result(true);
    }

    @Override
    public Result updateOrder(int orderId, Order order) {
        Order updatedOrder = this.orderDao.findById(orderId).get();
        updatedOrder.setOrder(order);
        this.orderDao.save(updatedOrder);
        return new Result(true);
    }

    @Override
    public Result addOrder(Order order) {
        this.orderDao.save(order);
        return new SuccessResult("order given.");
    }

    @Override
    public Result giveOrder(int customerId, int billLocationId, int locationId,
                             List<Integer> sizeId,List<Integer> amount, int discountCodeId) {
        Customer whoBuys = this.customerDao.findById(customerId).get();
        Location location = this.locationDao.findById(locationId).get();
        Location billLocation = this.locationDao.findById(billLocationId).get();
        DiscountCode discountCode = this.discountCodeDao.findById(discountCodeId).get();
        int totalPrice = 0;
        for (int i = 0; i < whoBuys.getBasket().size(); i++) {
            if (whoBuys.getBasket().get(i).getProduct().getDiscountPercentage().intValue() != 0){
                int discount = whoBuys.getBasket().get(i).getProduct().getPrice().intValue() *
                        whoBuys.getBasket().get(i).getProduct().getDiscountPercentage().intValue() / 100;
                int newPrice = whoBuys.getBasket().get(i).getProduct().getPrice().intValue() - discount;
                totalPrice += newPrice * amount.get(i);
            }
            else
                totalPrice += whoBuys.getBasket().get(i).getProduct().getPrice().intValue()*amount.get(i);
        }
        if (totalPrice <= whoBuys.getBudget()){
            for (int i = 0; i < whoBuys.getBasket().size(); i++) {
                if (this.stockDao.getProduct(whoBuys.getBasket().get(i).getId(), sizeId.get(i)).getCount() == 0)
                    return new ErrorResult("There is no enough stock for this item!!");
            }
            for (int i = 0; i < whoBuys.getBasket().size(); i++) {
                this.stockDao.getProduct(whoBuys.getBasket().get(i).getId(), sizeId.get(i)).decreaseCount(amount.get(i));
                this.stockDao.save(this.stockDao.getProduct(whoBuys.getBasket().get(i).getId(), sizeId.get(i)));
            }
        }
        else
            return new ErrorResult("There is no enough budget!!");
        LocalDateTime now = LocalDateTime.now();
        totalPrice -= discountCode.getPrice();
        discountCode.setAmount(discountCode.getAmount()-1);
        this.discountCodeDao.save(discountCode);
        Order order = new Order(totalPrice,now,whoBuys,location,
                billLocation,discountCode);
        this.orderDao.save(order);

        for (int i = 0; i < whoBuys.getBasket().size(); i++) {
            OrderDetail orderDetail = new OrderDetail(order,whoBuys.getBasket().get(i).getProduct(),
                    this.sizeDao.findById(sizeId.get(i)).get(),amount.get(i),false);
            this.orderDetailDao.save(orderDetail);
        }
        this.addOrder(order);
        int newBudget = whoBuys.getBudget()-totalPrice;
        whoBuys.setBudget(newBudget);
        whoBuys.setBasket(null);
        whoBuys.setLastLocation(location);
        this.customerDao.save(whoBuys);

        return new SuccessResult("Buying successfull");
    }


}
