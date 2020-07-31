package perrembud.crmcustom.validators;

import org.springframework.stereotype.Component;
import perrembud.crmcustom.exceptions.BadRequestException;
import perrembud.crmcustom.model.CustomerRequestDTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CustomerValidator {

    public static final Pattern VALID_NAME_REGEX = Pattern.compile("^[\\p{L} .'-]+$", Pattern.CASE_INSENSITIVE);


    public void validateCustomer(CustomerRequestDTO customerRequestDTO){

        if(customerRequestDTO.getCountryCode() == null || customerRequestDTO.getFirstName() == null ||
                customerRequestDTO.getLastName() == null){
            throw new BadRequestException("First name, last name and country code are required.");
        }

        Matcher matcher = VALID_NAME_REGEX.matcher(customerRequestDTO.getFirstName());

        if(!matcher.find()){
            throw new BadRequestException("First name is not valid.");
        }

        matcher = VALID_NAME_REGEX.matcher(customerRequestDTO.getLastName());

        if(!matcher.find()){
            throw new BadRequestException("Last name is not valid.");
        }

        if(customerRequestDTO.getCountryCode().length()!=2){
            throw new BadRequestException("Country code is not valid.");
        }

    }
}
