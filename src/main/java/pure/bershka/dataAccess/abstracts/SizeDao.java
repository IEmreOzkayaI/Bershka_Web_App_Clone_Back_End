package pure.bershka.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import pure.bershka.entities.concretes.Size;

public interface SizeDao extends JpaRepository<Size,Integer> {
}
