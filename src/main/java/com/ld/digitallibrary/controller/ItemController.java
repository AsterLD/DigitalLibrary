package com.ld.digitallibrary.controller;

import com.ld.digitallibrary.dto.file.FileDTO;
import com.ld.digitallibrary.dto.item.ReturnableItemDTO;
import com.ld.digitallibrary.dto.item.SavableItemDTO;
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
    public ReturnableItemDTO createItem(@RequestBody SavableItemDTO savableItemDTO) {
        return itemService.createItem(savableItemDTO);
    }

    @PostMapping(value = "/item/{itemId}", consumes = MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@PathVariable("itemId") Long itemId, @RequestBody MultipartFile file) {
        return itemService.uploadFile(itemId, file);
    }

    @GetMapping("/item/all")
    public List<ReturnableItemDTO> getAllItems(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return itemService.findAll(page, pageSize);
    }

    @GetMapping("/item/{itemId}")
    public ReturnableItemDTO getItemById(@PathVariable("itemId") Long itemId) {
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
    public List<ReturnableItemDTO> getAllItemsByUserId(@PathVariable("userId") Long userId) {
        return itemService.findAllByUserId(userId);
    }

    @PutMapping(value = "/item/{itemId}/update")
    public ReturnableItemDTO updateItemById(@PathVariable("itemId") Long itemId,
                                            @RequestBody SavableItemDTO savableItemDTO) {
        return itemService.updateItemById(savableItemDTO, itemId);
    }

    @PutMapping(value = "/item/{userId}/update-file", consumes = MULTIPART_FORM_DATA_VALUE)
    public String updateFileByItemId(@PathVariable("userId") Long itemId, @Parameter(required = true)
    @RequestBody MultipartFile file) {
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
