package perrembud.crmcustom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import perrembud.crmcustom.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}
