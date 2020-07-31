package perrembud.crmcustom.controller;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import perrembud.crmcustom.model.OrderRequestDTO;
import perrembud.crmcustom.model.OrderResponseDTO;
import perrembud.crmcustom.service.OrderService;

@RestController
@RequestMapping ("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(produces = "application/json")
    public OrderResponseDTO saveOrder (@RequestBody OrderRequestDTO orderRequestDTO){

        OrderResponseDTO orderResponseDTO = orderService.saveOrder(orderRequestDTO);

        return orderResponseDTO;
    }


}
