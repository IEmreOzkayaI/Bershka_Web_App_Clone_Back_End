package pure.bershka.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import pure.bershka.entities.concretes.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {
	
	Admin getByEmail(String email);
	
}
