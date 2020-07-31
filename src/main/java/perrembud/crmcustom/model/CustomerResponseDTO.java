package perrembud.crmcustom.model;

import lombok.Getter;
import lombok.Setter;
import perrembud.crmcustom.entity.OrderEntity;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CustomerResponseDTO {

    private int id;

    private String firstName;

    private String lastName;

    private String countryCode;

    private Date createdDate;

    private Date updatedDate;

    private boolean isActive;

    private List<OrderResponseDTO> orders;

}
