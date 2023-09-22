package com.ld.digitallibrary.service;

import com.ld.digitallibrary.dto.file.FileDTO;
import com.ld.digitallibrary.dto.item.ReturnableItemDTO;
import com.ld.digitallibrary.dto.item.SavableItemDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {

    ReturnableItemDTO createItem(SavableItemDTO savableItemDTO);

    String uploadFile(Long itemId, MultipartFile file);

    List<ReturnableItemDTO> findAll(Integer page, Integer pageSize);

    List<ReturnableItemDTO> findAllByUserId(Long userId);

    FileDTO getFileByItemId(Long itemId);

    String updateFile(Long itemId, MultipartFile file);

    ReturnableItemDTO findItemById(Long itemId);

    ReturnableItemDTO updateItemById(SavableItemDTO savableItemDTO, Long itemId);

    void deleteItemById(Long itemId);

    void deleteFileByItemId(Long itemId);
}
