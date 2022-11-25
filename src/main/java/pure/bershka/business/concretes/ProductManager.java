package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.business.abstracts.ProductService;
import pure.bershka.core.utilities.result.DataResult;
import pure.bershka.core.utilities.result.Result;
import pure.bershka.core.utilities.result.SuccessDataResult;
import pure.bershka.core.utilities.result.SuccessResult;
import pure.bershka.dataAccess.abstracts.ProductDao;
import pure.bershka.entities.concretes.Product;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    private ProductDao productDao;
    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data Listelendi");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Ürün eklendi");
    }

}
