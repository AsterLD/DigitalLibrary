package com.ld.digitallibrary.service;

import com.ld.digitallibrary.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    ItemDTO createItem(ItemDTO ItemDTO);

    List<ItemDTO> findAll();

    List<ItemDTO> findAllByUserId(Long userId);

    ItemDTO findItemById(Long id);

    ItemDTO updateItemById(ItemDTO ItemDTO, Long id);

    void deleteItemById(Long id);
}
