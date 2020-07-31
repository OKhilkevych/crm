package perrembud.crmcustom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perrembud.crmcustom.entity.CustomerEntity;
import perrembud.crmcustom.entity.ItemEntity;
import perrembud.crmcustom.entity.OrderEntity;
import perrembud.crmcustom.exceptions.BadRequestException;
import perrembud.crmcustom.model.ItemResponseDTO;
import perrembud.crmcustom.model.OrderRequestDTO;
import perrembud.crmcustom.model.OrderResponseDTO;
import perrembud.crmcustom.repository.CustomerRepository;
import perrembud.crmcustom.repository.OrderRepository;
import perrembud.crmcustom.validators.OrderValidator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderValidator orderValidator;

    @Override
    public OrderResponseDTO saveOrder(OrderRequestDTO orderRequestDTO) {

        Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(orderRequestDTO.getCustomerId());

        CustomerEntity customerEntity = null;

        if(customerEntityOptional.isPresent()){

            customerEntity = customerEntityOptional.get();
        }

        if(customerEntity == null){
            throw new BadRequestException ("Customer not found.");
        }

        orderValidator.validateOrder(orderRequestDTO);

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOrderStage(orderRequestDTO.getOrderStage());
        orderEntity.setManagerName(orderRequestDTO.getManagerName());
        orderEntity.setCreatedDate(new Date());
        orderEntity.setActive(true);
        orderEntity.setCustomerEntity(customerEntity);

        orderEntity = orderRepository.save(orderEntity);

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

        orderResponseDTO.setId(orderEntity.getId());
        orderResponseDTO.setOrderStage(orderEntity.getOrderStage());
        orderResponseDTO.setManagerName(orderEntity.getManagerName());
        orderResponseDTO.setCreatedDate(orderEntity.getCreatedDate());
        orderResponseDTO.setActive(true);


        return orderResponseDTO;
    }

    @Override
    public OrderResponseDTO getOrderById(Integer orderId) {

        Optional<OrderEntity> orderEntityOptional = orderRepository.findById(orderId);

        OrderEntity orderEntity;

        if(!orderEntityOptional.isPresent()){
            throw new BadRequestException("Order not found.");
        }

        orderEntity = orderEntityOptional.get();

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setId(orderEntity.getId());
        orderResponseDTO.setOrderStage(orderEntity.getOrderStage());
        orderResponseDTO.setManagerName(orderEntity.getManagerName());
        orderResponseDTO.setCreatedDate(orderEntity.getCreatedDate());
        orderResponseDTO.setUpdatedDate(orderEntity.getUpdatedDate());
        orderResponseDTO.setActive(orderEntity.isActive());

        return orderResponseDTO;
    }
}
