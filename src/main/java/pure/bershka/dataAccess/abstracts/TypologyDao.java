package pure.bershka.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import pure.bershka.entities.concretes.Typology;

public interface TypologyDao extends JpaRepository<Typology,Integer> {
}
