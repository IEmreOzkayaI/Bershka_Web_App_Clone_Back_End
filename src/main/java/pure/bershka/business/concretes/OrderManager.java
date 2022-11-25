package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.business.abstracts.OrderService;
import pure.bershka.dataAccess.abstracts.OrderDao;

@Service
public class OrderManager implements OrderService {
    private OrderDao orderDao;

    @Autowired
    public OrderManager(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
