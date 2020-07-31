package perrembud.crmcustom.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ItemResponseDTO {

    private int id;

    private String name;

    private Float price;

    private String type;

    private Date createdDate;

    private Date updatedDate;

    private boolean isActive;

}
