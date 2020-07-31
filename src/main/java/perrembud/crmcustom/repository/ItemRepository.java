package perrembud.crmcustom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import perrembud.crmcustom.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
}
