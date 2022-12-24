package pure.bershka.apiControllers;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pure.bershka.business.abstracts.CustomerService;
import pure.bershka.core.utilities.result.DataResult;
import pure.bershka.core.utilities.result.Result;
import pure.bershka.entities.concretes.Customer;
import pure.bershka.entities.dtos.CustomerDto;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin
@NoArgsConstructor
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

	@GetMapping("/get-customer")
	public DataResult<Customer> getCustomer(@RequestParam String email, @RequestParam String password){
		return this.customerService.getCustomer(email, password);
	}

	@PutMapping("/update")
	public Result update(int customerId, @RequestBody Customer customer){
		return this.customerService.updateCustomer(customerId,customer);
	}
	@DeleteMapping("/delete")
	public Result delete(int customerId){
		return this.customerService.deleteCustomer(customerId);
	}

	@DeleteMapping("/remove-favorite")
	public Result removeFromFavorite(int customerId, int productId){
		return this.customerService.removeFavorites(customerId,productId);
	}

	@PostMapping("/add-favorite")
	public Result addToFavorite(int customerId, int productId){
		return this.customerService.addFavorite(customerId,productId);
	}

	@DeleteMapping("/delete-basket")
	public Result deleteFromBasket(int customerId, int productId){
		return this.customerService.removeBasket(customerId,productId);
	}
	@PostMapping("/add-basket")
	public Result addToBasket(int customerId, int productId){
		return this.customerService.addBasket(customerId,productId);
	}
	@PutMapping("/add-location")
	public Result addLocation(int customerId,String title, String address, String city, String town, String postCode){
		return this.customerService.addLocation(customerId,title,address,city,town,postCode);
	}



//	@PostMapping("/sign-up")
//	public Result signUp(@RequestBody Customer customer) {
//		return this.customerService.signUp(customer);
//	}
}
