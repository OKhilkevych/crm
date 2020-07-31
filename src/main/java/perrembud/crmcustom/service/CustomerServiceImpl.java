package perrembud.crmcustom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perrembud.crmcustom.entity.CustomerEntity;
import perrembud.crmcustom.entity.OrderEntity;
import perrembud.crmcustom.exceptions.BadRequestException;
import perrembud.crmcustom.model.CustomerRequestDTO;
import perrembud.crmcustom.model.CustomerResponseDTO;
import perrembud.crmcustom.model.OrderResponseDTO;
import perrembud.crmcustom.repository.CustomerRepository;
import perrembud.crmcustom.validators.CustomerValidator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerValidator customerValidator;

    @Override
    public CustomerResponseDTO saveCustomer(CustomerRequestDTO customerRequestDTO) {

        customerValidator.validateCustomer(customerRequestDTO);


        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setFirstName(customerRequestDTO.getFirstName());
        customerEntity.setLastName(customerRequestDTO.getLastName());
        customerEntity.setCountryCode(customerRequestDTO.getCountryCode());
        customerEntity.setCreatedDate(new Date());
        customerEntity.setActive(true);

        customerEntity = customerRepository.save(customerEntity);


        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();

        customerResponseDTO.setId(customerEntity.getId());
        customerResponseDTO.setFirstName(customerEntity.getFirstName());
        customerResponseDTO.setLastName(customerEntity.getLastName());
        customerResponseDTO.setCountryCode(customerEntity.getCountryCode());
        customerResponseDTO.setCreatedDate(customerEntity.getCreatedDate());
        customerResponseDTO.setActive(true);

        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO getCustomerById(Integer customerId) {

        Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(customerId);

        CustomerEntity customerEntity;

        if(!customerEntityOptional.isPresent()){
            throw new BadRequestException("Customer not found.");
        }

        customerEntity = customerEntityOptional.get();


        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setId(customerEntity.getId());
        customerResponseDTO.setFirstName(customerEntity.getFirstName());
        customerResponseDTO.setLastName(customerEntity.getLastName());
        customerResponseDTO.setCountryCode(customerEntity.getCountryCode());
        customerResponseDTO.setCreatedDate(customerEntity.getCreatedDate());
        customerResponseDTO.setUpdatedDate(customerEntity.getUpdatedDate());
        customerResponseDTO.setActive(customerEntity.isActive());

        List <OrderResponseDTO> orderResponseDTOS = new ArrayList<>();

        for(OrderEntity orderEntity : customerEntity.getOrderEntities()){

            OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

            orderResponseDTO.setId(orderEntity.getId());
            orderResponseDTO.setOrderStage(orderEntity.getOrderStage());
            orderResponseDTO.setManagerName(orderEntity.getManagerName());
            orderResponseDTO.setCreatedDate(orderEntity.getCreatedDate());
            orderResponseDTO.setUpdatedDate(orderEntity.getUpdatedDate());
            orderResponseDTO.setActive(orderEntity.isActive());

            orderResponseDTOS.add(orderResponseDTO);
        }

        customerResponseDTO.setOrders(orderResponseDTOS);

        return customerResponseDTO;
    }


}
