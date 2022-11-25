package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.business.abstracts.OrderDetailService;
import pure.bershka.dataAccess.abstracts.OrderDetailDao;
import pure.bershka.entities.concretes.OrderDetail;

@Service
public class OrderDetailManager implements OrderDetailService {
    private OrderDetailDao orderDetailDao;

    @Autowired
    public OrderDetailManager(OrderDetailDao orderDetailDao) {
        this.orderDetailDao = orderDetailDao;
    }
}
