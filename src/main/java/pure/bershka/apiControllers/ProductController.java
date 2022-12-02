package pure.bershka.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pure.bershka.business.abstracts.ProductService;
import pure.bershka.core.utilities.result.DataResult;
import pure.bershka.core.utilities.result.Result;
import pure.bershka.entities.concretes.Gender;
import pure.bershka.entities.concretes.Product;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductController {
	private ProductService productService;


	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/hi")
	public String den() {
		return "Hello";
	}

	@GetMapping("/get-all")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Product product){
		return this.productService.add(product);
	}

	@GetMapping("/get-product")
	public DataResult<Product> getProduct(int id){
		return this.productService.getProduct(id);
	}

	@GetMapping("/get-by-name-like")
	public DataResult<List<Product>> getByNameLike(String name){
		return this.productService.getByNameLike(name);
	}

	@GetMapping("/get-by-price-between-values")
	public DataResult<List<Product>> getByPriceBetweenValues(BigDecimal min, BigDecimal max){
		return this.productService.getByPriceBetweenValues(min, max);
	}

	@GetMapping("/get-by-gender")
	public DataResult<List<Product>> getByGender(@RequestParam Gender gender){
		return this.productService.getByGender(gender);
	}

	@GetMapping("/get-discounted-products")
	public DataResult<List<Product>> getDiscountedProducts(){
		return this.productService.getDiscountedProducts();
	}
}
