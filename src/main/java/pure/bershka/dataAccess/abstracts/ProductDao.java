package pure.bershka.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pure.bershka.entities.concretes.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

}
