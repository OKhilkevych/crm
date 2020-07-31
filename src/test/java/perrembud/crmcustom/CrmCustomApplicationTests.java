package perrembud.crmcustom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import perrembud.crmcustom.exceptions.BadRequestException;
import perrembud.crmcustom.model.CustomerRequestDTO;
import perrembud.crmcustom.model.ItemRequestDTO;
import perrembud.crmcustom.validators.CustomerValidator;
import perrembud.crmcustom.validators.ItemValidator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrmCustomApplicationTests {

	@Autowired
	private CustomerValidator customerValidator;

	@Test
	public void contextLoads() {
	}

	@Test(expected = BadRequestException.class)
	public void customerValidatorTestNegative(){
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
		customerRequestDTO.setFirstName("!Olkk");
		customerRequestDTO.setLastName("MMKMK");
		customerRequestDTO.setCountryCode("CA");

		customerValidator.validateCustomer(customerRequestDTO);

	}

	@Test
	public void customerValidatorTestPositive (){
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
		customerRequestDTO.setFirstName("Olkk");
		customerRequestDTO.setLastName("MMKMK");
		customerRequestDTO.setCountryCode("CA");

		customerValidator.validateCustomer(customerRequestDTO);

	}


}
