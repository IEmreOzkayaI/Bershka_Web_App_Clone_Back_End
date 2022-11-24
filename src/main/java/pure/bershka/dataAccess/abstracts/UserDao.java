package pure.bershka.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import pure.bershka.entities.concretes.User;

public interface UserDao extends JpaRepository<User,Integer> {
}
