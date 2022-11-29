package pure.bershka.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import pure.bershka.entities.concretes.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
