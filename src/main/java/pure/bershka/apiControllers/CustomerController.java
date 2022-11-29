package pure.bershka.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pure.bershka.business.abstracts.CustomerService;
import pure.bershka.core.utilities.result.Result;
import pure.bershka.entities.concretes.Customer;
import pure.bershka.entities.dtos.CustomerDto;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin
public class CustomerController {
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping("/sign-up")
	public Result signUp(@RequestBody CustomerDto customerDto) {
		return this.customerService.signUp(customerDto);
	}
	
//	@PostMapping("/sign-up")
//	public Result signUp(@RequestBody Customer customer) {
//		return this.customerService.signUp(customer);
//	}
}
