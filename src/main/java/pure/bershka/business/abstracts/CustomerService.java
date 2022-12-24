package pure.bershka.business.abstracts;

import pure.bershka.apiControllers.CustomerController;
import pure.bershka.core.utilities.result.DataResult;
import pure.bershka.core.utilities.result.Result;
import pure.bershka.entities.concretes.Customer;
import pure.bershka.entities.concretes.Location;
import pure.bershka.entities.concretes.Product;
import pure.bershka.entities.dtos.CustomerDto;

public interface CustomerService {
	
	Result signUp(CustomerDto customerDto);

	DataResult<Customer> getCustomer(String email, String password);
	Result updateCustomer(int customerId, Customer customer);
	Result deleteCustomer(int customerId);
	Result removeFavorites(int customerId, int productId);
	Result addFavorite(int customerId, int productId);
	Result addBasket(int customerId, int productId);
	Result removeBasket(int customerId, int productId);
	Result addLocation(int customerId,String title, String address, String city, String town, String postCode);


}
