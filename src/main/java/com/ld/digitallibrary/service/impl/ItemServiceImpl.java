package com.ld.digitallibrary.service.impl;

import com.ld.digitallibrary.dto.file.FileDTO;
import com.ld.digitallibrary.dto.item.ReturnableItemDTO;
import com.ld.digitallibrary.dto.item.SavableItemDTO;
import com.ld.digitallibrary.entity.Item;
import com.ld.digitallibrary.repo.ItemRepository;
import com.ld.digitallibrary.repo.UserRepository;
import com.ld.digitallibrary.service.ItemService;
import com.ld.digitallibrary.service.S3Service;
import com.ld.digitallibrary.utils.ItemMapper;
import com.ld.digitallibrary.utils.Updater;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    private final UserRepository userRepository;

    private final S3Service s3Service;


    @Override
    public ReturnableItemDTO createItem(SavableItemDTO savableItemDTO) {
        Item item = new Item();
        item.setUser(userRepository.findById(savableItemDTO.getUserId()).orElseThrow());
        Updater.updateItem(item, savableItemDTO);
        itemRepository.save(item);
        return ItemMapper.mapItemToReturnableDTO(item);
    }

    @Override
    public String uploadFile(Long itemId, MultipartFile file) {
        Item item = itemRepository.findById(itemId).orElseThrow();
        String filename = s3Service.uploadFile(file);
        item.setName(filename);
        itemRepository.save(item);
        return filename;
    }

    @Override
    public List<ReturnableItemDTO> findAll(Integer page, Integer pageSize) {
        List<Item> itemList = itemRepository.findAll(PageRequest.of(page -1, pageSize)).getContent();
        return itemList.stream().map(ItemMapper::mapItemToReturnableDTO).collect(Collectors.toList());
    }

    @Override
    public List<ReturnableItemDTO> findAllByUserId(Long userId) {
        List<Item> itemList = itemRepository.findAllItemsByUserId(userId);
        return itemList.stream().map(ItemMapper::mapItemToReturnableDTO).collect(Collectors.toList());
    }

    @Override
    public FileDTO getFileByItemId(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow();
        return new FileDTO(item.getName(), s3Service.downloadFile(item.getName()));
    }

    @Override
    public String updateFile(Long itemId, MultipartFile file) {
        deleteFileByItemId(itemId);
        return uploadFile(itemId, file);
    }

    @Override
    public ReturnableItemDTO findItemById(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow();
        return ItemMapper.mapItemToReturnableDTO(item);

    }

    @Override
    public ReturnableItemDTO updateItemById(SavableItemDTO savableItemDTO, Long itemId) {
        Item itemFromDb = itemRepository.findById(itemId).orElseThrow();
        Updater.updateItem(itemFromDb, savableItemDTO);
        itemFromDb.setUser(userRepository.findById(savableItemDTO.getUserId()).orElseThrow());
        itemRepository.save(itemFromDb);
        return ItemMapper.mapItemToReturnableDTO(itemFromDb);

    }

    @Override
    public void deleteItemById(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow();
        itemRepository.delete(item);
    }

    @Override
    public void deleteFileByItemId(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow();
        s3Service.deleteFile(item.getName());
        item.setName(null);
        itemRepository.save(item);
    }
}
