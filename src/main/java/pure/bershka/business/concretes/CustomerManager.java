package pure.bershka.business.concretes;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pure.bershka.business.abstracts.CustomerService;
import pure.bershka.core.utilities.result.*;
import pure.bershka.dataAccess.abstracts.CustomerDao;
import pure.bershka.dataAccess.abstracts.LocationDao;
import pure.bershka.entities.concretes.Customer;
import pure.bershka.entities.concretes.Location;
import pure.bershka.entities.dtos.CustomerDto;

@Service
public class CustomerManager implements CustomerService {
	private CustomerDao customerDao;
	private LocationDao locationDao;

	@Autowired
	public CustomerManager(CustomerDao customerDao, LocationDao locationDao) {
		super();
		this.customerDao = customerDao;
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
			location.setTown(customerDto.getTown());
			location.setId(0);
			this.locationDao.save(location);
			
			Customer customer = new Customer();
			customer.setActive(false);
			customer.setAddDate(new Date());
			customer.setEmail(customerDto.getEmail());
			customer.setPassword(customerDto.getPassword());
			customer.setFirstName(customerDto.getFirstName());
			customer.setLastName(customerDto.getLastName());
			customer.setIdentityNumber(customerDto.getIdentityNumber());
			customer.setLastLocation(location);
			customer.setPhoneNumber(customerDto.getPhoneNumber());
			customer.setId(0);
			// rule 1
			// rule 2
			this.customerDao.save(customer);
			return new SuccessResult("Başarılı");


		}

	}

	@Override
	public DataResult<Customer> getCustomer(String email, String password) {
		Customer customer = this.customerDao.findByEmail(email);
		if(!customer.getEmail().isEmpty() && customer.isActive()==true) {
			return new SuccessDataResult<>(this.customerDao.getCustomerInfo(email, password),"Başarılı");
		}else if(!customer.getEmail().isEmpty() && customer.isActive()!=true){
			return new ErrorDataResult<Customer>("Kullanıcı aktivasyonu için bekleyiniz");
		}else {
			return new ErrorDataResult<Customer>("user bulunamadı");
		}
	}

	// FOR ADMIN
	@Override
	public Result updateCustomer(int customerId, Customer customer) {
		Customer updatedCustomer = this.customerDao.findById(customerId).get();
		updatedCustomer.setCustomer(customer);
		this.customerDao.save(updatedCustomer);
		return new SuccessResult();
	}

	@Override
	public Result deleteCustomer(int customerId) {
		Customer deletedCustomer = this.customerDao.findById(customerId).get();
		this.customerDao.delete(deletedCustomer);
		return new SuccessResult();

	}

	@Override
	public DataResult<Customer> getCustomerById(int id) {
		Customer customer = this.customerDao.findById(id).get();
		return new SuccessDataResult<Customer>(customer);
	}
}
