package sp.ms.feign.userservice.Repository;

import sp.ms.feign.userservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
