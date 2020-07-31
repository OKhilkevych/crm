package perrembud.crmcustom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perrembud.crmcustom.entity.ItemEntity;
import perrembud.crmcustom.model.ItemRequestDTO;
import perrembud.crmcustom.model.ItemResponseDTO;
import perrembud.crmcustom.repository.ItemRepository;
import perrembud.crmcustom.validators.ItemValidator;

import java.util.Date;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemValidator itemValidator;

    @Override
    public ItemResponseDTO saveItem(ItemRequestDTO itemRequestDTO) {

        itemValidator.validateItem(itemRequestDTO);

        ItemEntity itemEntity = new ItemEntity();

        itemEntity.setName(itemRequestDTO.getName());
        itemEntity.setPrice(itemRequestDTO.getPrice());
        itemEntity.setType(itemRequestDTO.getType());
        itemEntity.setCreatedDate(new Date());
        itemEntity.setActive(true);

        itemEntity = itemRepository.save(itemEntity);

        ItemResponseDTO itemResponseDTO = new ItemResponseDTO();

        itemResponseDTO.setId(itemEntity.getId());
        itemResponseDTO.setName(itemRequestDTO.getName());
        itemResponseDTO.setPrice(itemEntity.getPrice());
        itemResponseDTO.setType(itemEntity.getType());
        itemResponseDTO.setCreatedDate(itemEntity.getCreatedDate());
        itemResponseDTO.setActive(true);

        return itemResponseDTO;

    }
}
