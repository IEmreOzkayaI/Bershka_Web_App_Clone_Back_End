package pure.bershka.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pure.bershka.business.abstracts.AdminService;
import pure.bershka.dataAccess.abstracts.AdminDao;
;

@Service
public class AdminManager implements AdminService {
	
	private AdminDao adminDao;
	
	@Autowired
	public AdminManager(AdminDao adminDao) {
		this.adminDao=adminDao;
	}



}
