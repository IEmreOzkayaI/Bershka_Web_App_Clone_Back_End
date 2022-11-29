package pure.bershka.business.abstracts;

import pure.bershka.core.utilities.result.Result;
import pure.bershka.entities.dtos.CustomerDto;

public interface CustomerService {
	
	Result signUp(CustomerDto customerDto);

}
