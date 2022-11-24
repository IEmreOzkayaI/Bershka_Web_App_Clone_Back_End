package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.dataAccess.abstracts.ProductDao;

@Service
public class TypologyManager {
    private ProductDao productDao;

    @Autowired
    public TypologyManager(ProductDao productDao) {
        this.productDao = productDao;
    }
}