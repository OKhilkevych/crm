package perrembud.crmcustom.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {

    private OrderStage orderStage;

    private String managerName;

    private Integer customerId;

}
