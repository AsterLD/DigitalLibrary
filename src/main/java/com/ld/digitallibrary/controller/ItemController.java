package com.ld.digitallibrary.controller;

import com.ld.digitallibrary.dto.ItemDTO;
import com.ld.digitallibrary.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/item")
    public ItemDTO createItem(@RequestBody ItemDTO ItemDTO) {
        return itemService.createItem(ItemDTO);
    }

    @GetMapping("/item/all")
    public List<ItemDTO> getAllItems() {
        return itemService.findAll();
    }

    @GetMapping("/item/{id}")
    public ItemDTO getItemById(@PathVariable("id") Long itemId) {
        return itemService.findItemById(itemId);
    }

    @GetMapping("/item/user/{user_id}")
    public List<ItemDTO> getAllItemsByUserId(@PathVariable("user_id") Long userId) {
        return itemService.findAllByUserId(userId);
    }

    @PutMapping(value = "/item/{id}/update")
    public ItemDTO updateItemById(@PathVariable("id") Long itemId, @RequestBody ItemDTO itemDTO) {
        return itemService.updateItemById(itemDTO, itemId);
    }

    @DeleteMapping("/item/{id}/delete")
    public long deleteItemById(@PathVariable("id") Long itemId) {
        itemService.deleteItemById(itemId);
        return itemId;
    }

}
