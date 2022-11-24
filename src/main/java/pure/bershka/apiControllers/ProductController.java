package pure.bershka.apiControllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@GetMapping("/hi")
	public String den() {
		return "Hello";
	}
	
}
