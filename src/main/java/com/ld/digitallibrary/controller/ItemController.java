package com.ld.digitallibrary.controller;

import com.ld.digitallibrary.dto.FileDTO;
import com.ld.digitallibrary.dto.ItemDTO;
import com.ld.digitallibrary.service.ItemService;
import io.swagger.v3.oas.annotations.Parameter;
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

    @PostMapping(value = "/item/{itemId}", consumes = MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@PathVariable("itemId") Long itemId, @RequestBody MultipartFile file) {
        return itemService.uploadFile(itemId, file);
    }

    @GetMapping("/item/all")
    public List<ItemDTO> getAllItems() {
        return itemService.findAll();
    }

    @GetMapping("/item/{itemId}")
    public ItemDTO getItemById(@PathVariable("itemId") Long itemId) {
        return itemService.findItemById(itemId);
    }

    @GetMapping("/item/{itemId}/file")
    public ResponseEntity<byte[]> getFileByItemId(@PathVariable("itemId") Long itemId) {
        FileDTO fileDTO = itemService.getFileByItemId(itemId);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDTO.getFileName() + "\"")
                .body(fileDTO.getFileBytes());
    }

    @GetMapping("/item/user/{userId}")
    public List<ItemDTO> getAllItemsByUserId(@PathVariable("userId") Long userId) {
        return itemService.findAllByUserId(userId);
    }

    @PutMapping(value = "/item/{itemId}/update")
    public ItemDTO updateItemById(@PathVariable("itemId") Long itemId, @RequestBody ItemDTO itemDTO) {
        return itemService.updateItemById(itemDTO, itemId);
    }

    @PutMapping(value = "/item/{userId}/update-file", consumes = MULTIPART_FORM_DATA_VALUE)
    public String updateFileByItemId(@PathVariable("userId") Long itemId, @Parameter(required = true) @RequestBody MultipartFile file) {
        return itemService.updateFile(itemId, file);
    }

    @DeleteMapping("/item/{userId}/delete")
    public long deleteItemById(@PathVariable("userId") Long itemId) {
        itemService.deleteItemById(itemId);
        return itemId;
    }

    @DeleteMapping("/item/{userId}/delete-file")
    public long deleteFileByItemId(@PathVariable("userId") Long itemId) {
        itemService.deleteFileByItemId(itemId);
        return itemId;
    }

}
