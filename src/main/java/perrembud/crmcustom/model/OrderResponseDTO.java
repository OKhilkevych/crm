package perrembud.crmcustom.model;

import lombok.Getter;
import lombok.Setter;
import perrembud.crmcustom.entity.ItemEntity;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderResponseDTO {

    private int id;

    private OrderStage orderStage;

    private String managerName;

    private Date createdDate;

    private Date updatedDate;

    private boolean isActive;


}
