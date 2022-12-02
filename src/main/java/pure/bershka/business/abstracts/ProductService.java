package pure.bershka.business.abstracts;

import pure.bershka.core.utilities.result.DataResult;
import pure.bershka.core.utilities.result.Result;
import pure.bershka.entities.concretes.Gender;
import pure.bershka.entities.concretes.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    Result add(Product product);

    DataResult<Product> getProduct(int id);

    DataResult<List<Product>> getByNameLike(String name);

    DataResult<List<Product>> getByPriceBetweenValues(BigDecimal min, BigDecimal max);

    DataResult<List<Product>> getByGender(Gender gender);

    DataResult<List<Product>> getDiscountedProducts();
}
