package perrembud.crmcustom.validators;

import org.springframework.stereotype.Component;
import perrembud.crmcustom.exceptions.BadRequestException;
import perrembud.crmcustom.model.ItemRequestDTO;
import perrembud.crmcustom.model.OrderRequestDTO;

@Component
public class OrderValidator {

    public void validateOrder(OrderRequestDTO orderRequestDTO){
        if(orderRequestDTO.getOrderStage() == null){

            throw new BadRequestException("Order stage is required.");
        }
    }

}
