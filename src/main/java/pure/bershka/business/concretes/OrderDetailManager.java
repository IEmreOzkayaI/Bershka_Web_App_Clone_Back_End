package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.dataAccess.abstracts.OrderDetailDao;

@Service
public class OrderDetailManager {
    private OrderDetailDao orderDetailDao;

    @Autowired
    public OrderDetailManager(OrderDetailDao orderDetailDao) {
        this.orderDetailDao = orderDetailDao;
    }
}
