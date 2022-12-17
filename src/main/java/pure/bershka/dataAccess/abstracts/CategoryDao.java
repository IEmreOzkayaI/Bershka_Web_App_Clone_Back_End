package pure.bershka.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pure.bershka.entities.concretes.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

}
