package pure.bershka.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pure.bershka.entities.concretes.Gender;
import pure.bershka.entities.concretes.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    List<Product> getByNameContainsIgnoreCase(String name);
    List<Product> findByPriceGreaterThanEqualAndPriceLessThanEqual(BigDecimal min,BigDecimal max);

    List<Product> getByGender(Gender gender);

    List<Product> getByDiscountPercentageGreaterThan(BigDecimal min);
}
