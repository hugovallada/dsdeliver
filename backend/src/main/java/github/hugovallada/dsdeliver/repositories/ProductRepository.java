package github.hugovallada.dsdeliver.repositories;

import github.hugovallada.dsdeliver.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Encontra Todos , ordenando pelo nome de forma crescente
    List<Product> findAllByOrderByNameAsc();
}
