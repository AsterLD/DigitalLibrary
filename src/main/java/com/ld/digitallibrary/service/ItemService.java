package com.ld.digitallibrary.service;

import com.ld.digitallibrary.dto.ItemDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {

    ItemDTO createItem(ItemDTO itemDTO);

    String uploadFile(Long itemId, MultipartFile file);

    List<ItemDTO> findAll();

    List<ItemDTO> findAllByUserId(Long userId);

    ItemDTO findItemById(Long id);

    ItemDTO updateItemById(ItemDTO ItemDTO, Long id);

    void deleteItemById(Long id);
}
