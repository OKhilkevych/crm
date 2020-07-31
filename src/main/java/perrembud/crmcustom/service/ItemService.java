package perrembud.crmcustom.service;

import perrembud.crmcustom.model.ItemRequestDTO;
import perrembud.crmcustom.model.ItemResponseDTO;

public interface ItemService {

    ItemResponseDTO saveItem(ItemRequestDTO itemRequestDTO);

}
