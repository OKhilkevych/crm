package perrembud.crmcustom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import perrembud.crmcustom.model.ItemRequestDTO;
import perrembud.crmcustom.model.ItemResponseDTO;
import perrembud.crmcustom.service.ItemService;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(produces = "application/json")
    public ItemResponseDTO saveItem(@RequestBody ItemRequestDTO itemRequestDTO){

        ItemResponseDTO itemResponseDTO = itemService.saveItem(itemRequestDTO);

        return itemResponseDTO;
    }

}
