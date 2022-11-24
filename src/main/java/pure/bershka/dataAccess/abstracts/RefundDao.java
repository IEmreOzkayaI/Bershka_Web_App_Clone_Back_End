package pure.bershka.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import pure.bershka.entities.concretes.Refund;

public interface RefundDao extends JpaRepository<Refund,Integer> {
}
