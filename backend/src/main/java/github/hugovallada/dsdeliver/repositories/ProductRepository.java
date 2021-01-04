package github.hugovallada.dsdeliver.repositories;

import github.hugovallada.dsdeliver.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
