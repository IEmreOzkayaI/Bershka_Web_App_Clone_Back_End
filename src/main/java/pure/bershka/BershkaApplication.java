package pure.bershka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BershkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BershkaApplication.class, args);
	}

	@GetMapping("/hi")
	public String den() {
		return "Hello";
	}
}
