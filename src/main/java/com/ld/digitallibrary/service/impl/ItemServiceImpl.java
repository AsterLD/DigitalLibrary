package com.ld.digitallibrary.service.impl;

import com.ld.digitallibrary.dto.ItemDTO;
import com.ld.digitallibrary.entity.Item;
import com.ld.digitallibrary.entity.User;
import com.ld.digitallibrary.repo.ItemRepository;
import com.ld.digitallibrary.service.ItemService;
import com.ld.digitallibrary.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public List<ItemDTO> findAll() {
        List<Item> itemList = itemRepository.findAll();
        return itemList.stream().map(Mapper::mapItemToItemDTO).collect(Collectors.toList());
    }

    @Override
    public ItemDTO findItemById(Long id) {
        Item item = itemRepository.findById(id).orElseThrow();
        return Mapper.mapItemToItemDTO(item);
    }
}
