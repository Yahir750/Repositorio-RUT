package ReUseTech.User_Service.repository;

import ReUseTech.User_Service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}