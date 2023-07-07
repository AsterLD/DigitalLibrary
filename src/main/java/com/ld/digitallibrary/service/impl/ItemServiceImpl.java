package com.ld.digitallibrary.service.impl;

import com.ld.digitallibrary.dto.ItemDTO;
import com.ld.digitallibrary.entity.Item;
import com.ld.digitallibrary.repo.ItemRepository;
import com.ld.digitallibrary.repo.UserRepository;
import com.ld.digitallibrary.service.ItemService;
import com.ld.digitallibrary.service.S3Service;
import com.ld.digitallibrary.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    private final UserRepository userRepository;

    private final S3Service s3Service;


    @Override
    public ItemDTO createItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setUser(userRepository.findById(itemDTO.getUserId()).orElseThrow());
        Mapper.updateItem(item, itemDTO);
        itemRepository.save(item);
        return Mapper.mapItemToItemDTO(item);
    }

    @Override
    public String uploadFile(Long itemId, MultipartFile file) {
        Item item = itemRepository.findById(itemId).orElseThrow();
        String filename = null;
        try {
            filename = s3Service.uploadFile(file.getInputStream(), file.getOriginalFilename());
            item.setName(filename);
            itemRepository.save(item);
        } catch (IOException e) {

        }
        return filename;
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
