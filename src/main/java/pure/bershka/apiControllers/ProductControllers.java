package pure.bershka.apiControllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductControllers {
	
	@GetMapping("/hi")
	public String den() {
		return "Hello";
	}
	
}
