package pure.bershka.business.concretes;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pure.bershka.business.abstracts.CustomerService;
import pure.bershka.core.utilities.result.*;
import pure.bershka.dataAccess.abstracts.*;
import pure.bershka.entities.concretes.Customer;
import pure.bershka.entities.concretes.Item;
import pure.bershka.entities.concretes.Location;
import pure.bershka.entities.concretes.Product;
import pure.bershka.entities.dtos.CustomerDto;

@Service
public class CustomerManager implements CustomerService {
	private CustomerDao customerDao;
	private StockDao stockDao;
	private ProductDao productDao;
	private LocationDao locationDao;

	private SizeDao sizeDao;

	@Autowired
	public CustomerManager(CustomerDao customerDao, StockDao stockDao, ProductDao productDao,LocationDao locationDao) {
		this.customerDao=customerDao;
		this.stockDao = stockDao;
		this.productDao = productDao;
		this.locationDao = locationDao;
	}

	@Override
	public Result signUp(CustomerDto customerDto) {

		if (this.customerDao.findByEmail(customerDto.getEmail()) != null) {
			return new ErrorResult("Kullanıcı Mevcut");
		} else {

			Location location = new Location();
			location.setAddress(customerDto.getAddress());
			location.setCity(customerDto.getCity());
			location.setPostCode(customerDto.getPostalCode());
			location.setTitle(customerDto.getAddressTitle());
			location.setId(0);
			this.locationDao.save(location);

			Customer customer = new Customer();
			customer.setActive(false);
			customer.setAddDate(LocalDateTime.now());
			customer.setEmail(customerDto.getEmail());
			customer.setFirstName(customerDto.getFirstName());
			customer.setLastName(customerDto.getLastName());
			customer.setId(0);
			customer.setIdentityNumber(customerDto.getIdentityNumber());
			customer.setPassword(customerDto.getPassword());
			customer.setPhoneNumber(customerDto.getPhoneNumber());
			this.customerDao.save(customer);
			return new SuccessResult("Başarılı");

		}
		
	}

	@Override
	public DataResult<Customer> getCustomer(String email, String password) {
		return new SuccessDataResult<>(this.customerDao.getCustomerInfo(email,password));
	}


	// FOR ADMIN
	@Override
	public Result updateCustomer(int customerId, Customer customer){
		Customer updatedCustomer = this.customerDao.findById(customerId).get();
		updatedCustomer.setCustomer(customer);
		this.customerDao.save(updatedCustomer);
		return new SuccessResult();
	}
	@Override
	public Result deleteCustomer(int customerId){
		Customer deletedCustomer = this.customerDao.findById(customerId).get();
		this.customerDao.delete(deletedCustomer);
		return new SuccessResult();

	}

	@Override
	public DataResult<Customer> getCustomerById(int id) {
		Customer customer = this.customerDao.findById(id).get();
		return new SuccessDataResult<Customer>(customer);
	}

	@Override
	public Result removeFavorites(int customerId, int productId) {
		Customer removeFromFavorite = this.customerDao.findById(customerId).get();
		if (removeFromFavorite.getFavorites().size() != 0){
			for (int i = 0; i < removeFromFavorite.getFavorites().size(); i++) {
				if(removeFromFavorite.getFavorites().get(i).getId() == productId){
					removeFromFavorite.getFavorites().remove(i);
					this.customerDao.save(removeFromFavorite);
					return new SuccessResult("Ürün favorilerden çıkarıldı.");
				}
			}

		}
		return new ErrorResult("Ürün favorilerden çıkarılamadı!!");
	}

	@Override
	public Result addFavorite(int customerId, int productId) {
		Customer toAdd = this.customerDao.findById(customerId).get();
		Product product = this.productDao.findById(productId).get();
		toAdd.getFavorites().add(product);
		this.customerDao.save(toAdd);
		return new SuccessResult("Ürün favorilere eklendi.");
	}

	@Override
	public Result addBasket(int customerId, int productId, int sizeId, int amount) {
		Customer toAddBasket = this.customerDao.findById(customerId).get();
		Item item = new Item(0,this.productDao.findById(productId).get(),this.sizeDao.findById(sizeId).get(), amount);
		toAddBasket.getBasket().add(item);
		this.customerDao.save(toAddBasket);
		return new SuccessResult("Ürün sepete eklendi.");
	}

	@Override
	public Result removeBasket(int customerId, int productId) {
		Customer removeFromBasket = this.customerDao.findById(customerId).get();
		if (removeFromBasket.getBasket().size()!=0){
			for (int i = 0; i < removeFromBasket.getBasket().size(); i++) {
				if(removeFromBasket.getBasket().get(i).getId() == productId){
					removeFromBasket.getBasket().remove(i);
					this.customerDao.save(removeFromBasket);
					return new SuccessResult("Ürün sepetten çıkarıldı.");
				}
			}
		}
		return new ErrorResult("Ürün sepetten çıkarılamadı!!!");
	}

	@Override
	public Result addLocation(int customerId,String title, String address, String city, String town, String postCode) {
		Location location = new Location(title,address,city,town,postCode);
		Customer customer = this.customerDao.findById(customerId).get();
		this.locationDao.save(location);
		customer.getLocations().add(location);
		this.customerDao.save(customer);
		return new SuccessResult("Address oluşturuldu.");
	}

}
