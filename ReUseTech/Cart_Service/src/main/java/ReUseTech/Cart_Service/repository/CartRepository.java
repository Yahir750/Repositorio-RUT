package ReUseTech.Cart_Service.repository;

import ReUseTech.Cart_Service.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}