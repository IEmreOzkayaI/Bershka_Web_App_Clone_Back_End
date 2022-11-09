package pure.bershka.dataAccess.concretes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pure.bershka.entities.concretes.Product;

@Repository
public interface productService extends JpaRepository<Product, Integer> {

}
