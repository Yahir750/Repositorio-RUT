package ReUseTech.Product_Service.repository;

import ReUseTech.Product_Service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Creo que aqui se pueden hacer personalizadas
}