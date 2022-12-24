package pure.bershka.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pure.bershka.entities.concretes.Product;
import pure.bershka.entities.concretes.Stock;

@Repository
public interface StockDao extends JpaRepository<Stock,Integer> {

    @Query("SELECT s FROM Stock s WHERE s.product.id = :productId AND s.size.id = :sizeId")
    Stock getProduct(int productId, int sizeId);
}
