package perrembud.crmcustom.validators;

import org.springframework.stereotype.Component;
import perrembud.crmcustom.exceptions.BadRequestException;
import perrembud.crmcustom.model.ItemRequestDTO;

@Component
public class ItemValidator {

    public void validateItem(ItemRequestDTO itemRequestDTO){
        if(itemRequestDTO.getName() == null || itemRequestDTO.getPrice() == null){

            throw new BadRequestException("Name and price are required.");
        }
    }

}
