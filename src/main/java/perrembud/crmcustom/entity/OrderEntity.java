package perrembud.crmcustom.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import perrembud.crmcustom.model.OrderStage;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="orders")
@Getter
@Setter
public class OrderEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @Column(name="order_stage")
    private OrderStage orderStage;

    @Column(name="manager_name")
    private String managerName;


}
