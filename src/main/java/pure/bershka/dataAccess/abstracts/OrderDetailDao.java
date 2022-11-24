package pure.bershka.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import pure.bershka.entities.concretes.OrderDetail;

public interface OrderDetailDao extends JpaRepository<OrderDetail,Integer> {
}
