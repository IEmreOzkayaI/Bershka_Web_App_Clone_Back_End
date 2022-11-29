package pure.bershka.business.concretes;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pure.bershka.business.abstracts.CustomerService;
import pure.bershka.core.utilities.result.ErrorResult;
import pure.bershka.core.utilities.result.Result;
import pure.bershka.core.utilities.result.SuccessResult;
import pure.bershka.dataAccess.abstracts.CustomerDao;
import pure.bershka.entities.concretes.Customer;
import pure.bershka.entities.dtos.CustomerDto;

@Service
public class CustomerManager implements CustomerService {
	private CustomerDao customerDao;
	
	@Autowired
	public CustomerManager(CustomerDao customerDao) {
		super();
		this.customerDao=customerDao;
	}

	@Override
	public Result signUp(CustomerDto customerDto) {
	
		if(customerDto.getEmail().equalsIgnoreCase("string")) {
			return new ErrorResult("Kullanıcı Boş");
		}else {
			Customer customer = new Customer();
			customer.setActive(false);
			customer.setAddDate(new Date());
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

}
