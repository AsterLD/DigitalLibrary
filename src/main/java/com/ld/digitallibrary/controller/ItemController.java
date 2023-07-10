package com.ld.digitallibrary.controller;

import com.ld.digitallibrary.dto.FileDTO;
import com.ld.digitallibrary.dto.ItemDTO;
import com.ld.digitallibrary.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;


@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping(value = "/item")
    public ItemDTO createItem(@RequestBody ItemDTO itemDTO) {
        return itemService.createItem(itemDTO);
    }

    @PostMapping(value = "/item/{id}", consumes = MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@PathVariable("id") Long itemId, @RequestBody MultipartFile file) {
        return itemService.uploadFile(itemId, file);
    }

    @GetMapping("/item/all")
    public List<ItemDTO> getAllItems() {
        return itemService.findAll();
    }

    @GetMapping("/item/{id}")
    public ItemDTO getItemById(@PathVariable("id") Long itemId) {
        return itemService.findItemById(itemId);
    }

    @GetMapping("/item/{id}/file")
    public ResponseEntity<byte[]> getFileByItemId(@PathVariable("id") Long itemId) {
        FileDTO fileDTO = itemService.getFileByItemId(itemId);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDTO.getFileName() + "\"")
                .body(fileDTO.getFileBytes());
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
