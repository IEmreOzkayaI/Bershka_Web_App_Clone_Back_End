package pure.bershka.business.concretes;

import org.springframework.stereotype.Service;
import pure.bershka.dataAccess.abstracts.ProductDao;

@Service
public class OrderDetailManager {
    private ProductDao productDao;

    public OrderDetailManager(ProductDao productDao) {
        this.productDao = productDao;
    }
}
