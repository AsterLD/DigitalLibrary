package com.ld.digitallibrary.service;

import com.ld.digitallibrary.dto.ItemDTO;
import com.ld.digitallibrary.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<ItemDTO> findAll();

    ItemDTO findItemById(Long id);
}
