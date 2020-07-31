package perrembud.crmcustom.service;


import perrembud.crmcustom.model.CustomerRequestDTO;
import perrembud.crmcustom.model.CustomerResponseDTO;

public interface CustomerService {

    CustomerResponseDTO saveCustomer(CustomerRequestDTO customerRequestDTO);

    CustomerResponseDTO getCustomerById(Integer customerId);

}
