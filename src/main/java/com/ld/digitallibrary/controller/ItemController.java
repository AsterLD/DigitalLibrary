package com.ld.digitallibrary.controller;

import com.ld.digitallibrary.dto.ItemDTO;
import com.ld.digitallibrary.dto.UserDTO;
import com.ld.digitallibrary.entity.Item;
import com.ld.digitallibrary.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/item/{id}")
    public ItemDTO getItemById(@PathVariable("id") Long itemId) {
        return itemService.findItemById(itemId);
    }

    @GetMapping("/item/all")
    public List<ItemDTO> getAllItems() {
        return itemService.findAll();
    }

}
