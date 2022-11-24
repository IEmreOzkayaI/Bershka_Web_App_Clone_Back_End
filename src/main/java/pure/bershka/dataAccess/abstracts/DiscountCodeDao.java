package pure.bershka.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import pure.bershka.entities.concretes.DiscountCode;

public interface DiscountCodeDao extends JpaRepository<DiscountCode,Integer> {
}
