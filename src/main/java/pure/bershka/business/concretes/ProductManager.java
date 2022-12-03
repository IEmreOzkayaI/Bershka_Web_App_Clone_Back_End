package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.business.abstracts.ProductService;
import pure.bershka.core.utilities.result.*;

import pure.bershka.dataAccess.abstracts.ProductDao;

import pure.bershka.entities.concretes.*;

import java.math.BigDecimal;
import java.util.List;
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
	public DataResult<List<Product>> getByFilterTypologyAndSizeAndColorAndPrice(String typology, String size, String color, BigDecimal min, BigDecimal max) {
		return new SuccessDataResult<>(this.productDao.getByFilterTypologyAndSizeAndColorAndPrice(typology,size,color,min,max));
	}

	@Override
	public DataResult<List<Product>> getByFilterTypology(String typology) {
		return new SuccessDataResult<>(this.productDao.getByFilterTypology(typology));
	}

	@Override
	public DataResult<List<Product>> getByFilterTypologyAndSize(String typology, String size) {
		return new SuccessDataResult<>(this.productDao.getByFilterTypologyAndSize(typology,size));
	}

	@Override
	public DataResult<List<Product>> getByFilterTypologyAndColor(String typology, String color) {
		return new SuccessDataResult<>(this.productDao.getByFilterTypologyAndColor(typology,color));
	}

	@Override
	public DataResult<List<Product>> getByFilterTypologyAndPrice(String typology, BigDecimal min, BigDecimal max) {
		return new SuccessDataResult<>(this.productDao.getByFilterTypologyAndPrice(typology,min,max));
	}

	@Override
	public DataResult<List<Product>> getByFilterTypologyAndSizeAndColor(String typology, String size, String color) {
		return new SuccessDataResult<>(this.productDao.getByFilterTypologyAndSizeAndColor(typology,size,color));
	}

	@Override
	public DataResult<List<Product>> getByFilterTypologyAndSizeAndPrice(String typology, String size, BigDecimal min, BigDecimal max) {
		return new SuccessDataResult<>(this.productDao.getByFilterTypologyAndSizeAndPrice(typology,size,min,max));
	}

	@Override
	public DataResult<List<Product>> getByFilterTypologyAndColorAndPrice(String typology, String color, BigDecimal min, BigDecimal max) {
		return new SuccessDataResult<>(this.productDao.getByFilterTypologyAndColorAndPrice(typology,color,min,max));
	}

	///**********************

	@Override
	public DataResult<List<Product>> getByFilterCategoryAndSizeAndColorAndPrice(String category, String size, String color, BigDecimal min, BigDecimal max) {
		return new SuccessDataResult<>(this.productDao.getByFilterCategoryAndSizeAndColorAndPrice(category,size,color,min,max));
	}

	@Override
	public DataResult<List<Product>> getByFilterCategory(String category) {
		return new SuccessDataResult<>(this.productDao.getByFilterCategory(category));
	}

	@Override
	public DataResult<List<Product>> getByFilterCategoryAndSize(String category, String size) {
		return new SuccessDataResult<>(this.productDao.getByFilterCategoryAndSize(category,size));
	}

	@Override
	public DataResult<List<Product>> getByFilterCategoryAndColor(String category, String color) {
		return new SuccessDataResult<>(this.productDao.getByFilterCategoryAndColor(category,color));
	}

	@Override
	public DataResult<List<Product>> getByFilterCategoryAndPrice(String category, BigDecimal min, BigDecimal max) {
		return new SuccessDataResult<>(this.productDao.getByFilterCategoryAndPrice(category,min,max));
	}

	@Override
	public DataResult<List<Product>> getByFilterCategoryAndSizeAndColor(String category, String size, String color) {
		return new SuccessDataResult<>(this.productDao.getByFilterCategoryAndSizeAndColor(category,size,color));
	}

	@Override
	public DataResult<List<Product>> getByFilterCategoryAndSizeAndPrice(String category, String size, BigDecimal min, BigDecimal max) {
		return new SuccessDataResult<>(this.productDao.getByFilterCategoryAndSizeAndPrice(category,size,min,max));
	}

	@Override
	public DataResult<List<Product>> getByFilterCategoryAndColorAndPrice(String category, String color, BigDecimal min, BigDecimal max) {
		return new SuccessDataResult<>(this.productDao.getByFilterCategoryAndColorAndPrice(category,color,min,max));
	}
}
