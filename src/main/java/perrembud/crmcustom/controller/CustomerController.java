package perrembud.crmcustom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import perrembud.crmcustom.entity.CustomerEntity;
import perrembud.crmcustom.model.CustomerRequestDTO;
import perrembud.crmcustom.model.CustomerResponseDTO;
import perrembud.crmcustom.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(produces = "application/json")
    public CustomerResponseDTO saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){

        CustomerResponseDTO customerResponseDTO = customerService.saveCustomer(customerRequestDTO);

        return customerResponseDTO;
    }

    @GetMapping("/{customerId}")
    public CustomerResponseDTO getCustomer(@PathVariable int customerId){

        CustomerResponseDTO customerResponseDTO = customerService.getCustomerById(customerId);

        return customerResponseDTO;
    }


}