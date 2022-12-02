package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.business.abstracts.ProductService;
import pure.bershka.core.utilities.result.*;

import pure.bershka.dataAccess.abstracts.ProductDao;

import pure.bershka.entities.concretes.Gender;
import pure.bershka.entities.concretes.Product;

import java.math.BigDecimal;
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
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi");
	}

	@Override
	public DataResult<Product> getProduct(int id) {
		return new SuccessDataResult<>(this.productDao.findById(id).get());
	}

	@Override
	public DataResult<List<Product>> getByNameLike(String name) {
		return new SuccessDataResult<>(this.productDao.getByNameContainsIgnoreCase(name));
	}

	@Override
	public DataResult<List<Product>> getByGender(Gender gender) {
		return new SuccessDataResult<>(this.productDao.getByGender(gender));
	}

	@Override
	public DataResult<List<Product>> getDiscountedProducts() {
		return new SuccessDataResult<>(this.productDao.getByDiscountPercentageGreaterThan(new BigDecimal(0)));
	}
	@Override
	public DataResult<List<Product>> getByPriceBetweenValues(BigDecimal min, BigDecimal max) {
		return new SuccessDataResult<>(this.productDao.findByPriceGreaterThanEqualAndPriceLessThanEqual(min,max));
	}
}
