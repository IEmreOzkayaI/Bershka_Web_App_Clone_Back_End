package pure.bershka.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pure.bershka.business.abstracts.UserService;
import pure.bershka.core.utilities.result.ErrorResult;
import pure.bershka.core.utilities.result.Result;
import pure.bershka.core.utilities.result.SuccessResult;
import pure.bershka.entities.concretes.Admin;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
	@PostMapping("/sign-in")
	public Result signIn(@RequestParam String email,@RequestParam String password) {
		return this.userService.signIn(email, password);
	}
}
