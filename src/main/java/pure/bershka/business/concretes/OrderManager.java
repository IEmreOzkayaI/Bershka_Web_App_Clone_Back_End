package pure.bershka.business.concretes;

import org.springframework.stereotype.Service;
import pure.bershka.dataAccess.abstracts.ProductDao;

@Service
public class OrderManager {
    private ProductDao productDao;

    public OrderManager(ProductDao productDao) {
        this.productDao = productDao;
    }
}
