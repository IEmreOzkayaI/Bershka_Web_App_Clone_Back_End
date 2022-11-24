package pure.bershka.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import pure.bershka.entities.concretes.Order;

public interface OrderDao extends JpaRepository<Order,Integer> {
}
