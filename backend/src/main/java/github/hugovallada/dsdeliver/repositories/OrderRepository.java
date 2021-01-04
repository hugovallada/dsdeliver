package github.hugovallada.dsdeliver.repositories;

import github.hugovallada.dsdeliver.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
