package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pure.bershka.business.abstracts.UserService;
import pure.bershka.core.utilities.result.ErrorResult;
import pure.bershka.core.utilities.result.Result;
import pure.bershka.core.utilities.result.SuccessResult;
import pure.bershka.dataAccess.abstracts.UserDao;
import pure.bershka.entities.concretes.User;

@Service
public class UserManager implements UserService {
    private UserDao userDao;
    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }
    
	public Result signIn(String email, String password) {
		User user = this.userDao.getByEmail(email);
		if(user.getPassword().equalsIgnoreCase(password)) {
			return new SuccessResult("Giriş Başarılı");
		}else {
			return new ErrorResult("Giriş Başarısız");
		}
	}
}
