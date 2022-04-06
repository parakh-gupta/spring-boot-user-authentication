package springboot.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.usermanagement.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
