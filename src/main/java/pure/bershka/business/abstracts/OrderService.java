package pure.bershka.business.abstracts;

import pure.bershka.core.utilities.result.DataResult;
import pure.bershka.core.utilities.result.Result;
import pure.bershka.entities.concretes.Order;

import java.util.List;

public interface OrderService {


    DataResult<List<Order>> getAllOrdersForAdmin();
    Result deleteOrder(int orderId);
    Result updateOrder(int orderId, Order order);
    Result giveOrder(Order order);
}
