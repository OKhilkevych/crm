package perrembud.crmcustom.service;

import perrembud.crmcustom.model.OrderRequestDTO;
import perrembud.crmcustom.model.OrderResponseDTO;

public interface OrderService {

    OrderResponseDTO saveOrder(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO getOrderById(Integer orderId);

}
