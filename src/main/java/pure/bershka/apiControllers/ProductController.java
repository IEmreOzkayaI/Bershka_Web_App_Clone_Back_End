package pure.bershka.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pure.bershka.business.abstracts.ProductService;
import pure.bershka.core.utilities.result.DataResult;
import pure.bershka.core.utilities.result.Result;
import pure.bershka.entities.concretes.Product;

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
	
}
