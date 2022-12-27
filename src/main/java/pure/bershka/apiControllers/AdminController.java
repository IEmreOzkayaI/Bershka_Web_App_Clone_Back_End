package pure.bershka.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pure.bershka.business.abstracts.AdminService;

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
public class AdminController {
	private AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService=adminService;
	}
}
