package perrembud.crmcustom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import perrembud.crmcustom.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
