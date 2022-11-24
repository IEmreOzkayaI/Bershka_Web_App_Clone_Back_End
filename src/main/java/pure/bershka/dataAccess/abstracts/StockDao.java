package pure.bershka.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import pure.bershka.entities.concretes.Stock;

public interface StockDao extends JpaRepository<Stock,Integer> {
}
