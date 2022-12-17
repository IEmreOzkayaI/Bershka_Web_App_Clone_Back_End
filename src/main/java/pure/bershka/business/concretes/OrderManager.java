package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.business.abstracts.OrderService;
import pure.bershka.core.utilities.result.DataResult;
import pure.bershka.core.utilities.result.Result;
import pure.bershka.core.utilities.result.SuccessDataResult;
import pure.bershka.core.utilities.result.SuccessResult;
import pure.bershka.dataAccess.abstracts.OrderDao;
import pure.bershka.entities.concretes.Order;

import java.util.List;

@Service
public class OrderManager implements OrderService {
    private OrderDao orderDao;

    @Autowired
    public OrderManager(OrderDao orderDao) {
        this.orderDao = orderDao;
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
    public Result giveOrder(Order order) {
        this.orderDao.save(order);
        return new SuccessResult("order given.");
    }


}
