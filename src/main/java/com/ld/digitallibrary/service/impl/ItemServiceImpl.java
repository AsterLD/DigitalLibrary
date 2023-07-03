package com.ld.digitallibrary.service.impl;

import com.ld.digitallibrary.dto.ItemDTO;
import com.ld.digitallibrary.entity.Item;
import com.ld.digitallibrary.repo.ItemRepository;
import com.ld.digitallibrary.repo.UserRepository;
import com.ld.digitallibrary.service.ItemService;
import com.ld.digitallibrary.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    private final UserRepository userRepository;


    @Override
    public ItemDTO createItem(ItemDTO itemDTO) {
        Item item = new Item();
        Mapper.updateItem(item, itemDTO);
        item.setUser(userRepository.findById(itemDTO.getUserId()).orElseThrow());
        itemRepository.save(item);
        return Mapper.mapItemToItemDTO(item);
    }

    @Override
    public List<ItemDTO> findAll() {
        List<Item> itemList = itemRepository.findAll();
        return itemList.stream().map(Mapper::mapItemToItemDTO).collect(Collectors.toList());
    }

    @Override
    public List<ItemDTO> findAllByUserId(Long userId) {
        List<Item> itemList = itemRepository.findAllItemsByUserId(userId);
        return itemList.stream().map(Mapper::mapItemToItemDTO).collect(Collectors.toList());
    }

    @Override
    public ItemDTO findItemById(Long id) {
        Item item = itemRepository.findById(id).orElseThrow();
        return Mapper.mapItemToItemDTO(item);

    }

    @Override
    public ItemDTO updateItemById(ItemDTO itemDTO, Long id) {
        Item itemFromDb = itemRepository.findById(id).orElseThrow();
        Mapper.updateItem(itemFromDb, itemDTO);
        itemFromDb.setUser(userRepository.findById(itemDTO.getUserId()).orElseThrow());
        itemRepository.save(itemFromDb);
        return Mapper.mapItemToItemDTO(itemFromDb);

    }

    @Override
    public void deleteItemById(Long id) {
        Item item = itemRepository.findById(id).orElseThrow();
        itemRepository.delete(item);
    }
}
