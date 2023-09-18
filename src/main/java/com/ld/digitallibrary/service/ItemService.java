package com.ld.digitallibrary.service;

import com.ld.digitallibrary.dto.FileDTO;
import com.ld.digitallibrary.dto.ItemDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {

    ItemDTO createItem(ItemDTO itemDTO);

    String uploadFile(Long itemId, MultipartFile file);

    List<ItemDTO> findAll(Integer page, Integer pageSize);

    List<ItemDTO> findAllByUserId(Long userId);

    FileDTO getFileByItemId(Long itemId);

    String updateFile(Long itemId, MultipartFile file);

    ItemDTO findItemById(Long itemId);

    ItemDTO updateItemById(ItemDTO ItemDTO, Long itemId);

    void deleteItemById(Long itemId);

    void deleteFileByItemId(Long itemId);
}
