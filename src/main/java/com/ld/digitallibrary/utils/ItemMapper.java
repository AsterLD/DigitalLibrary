package com.ld.digitallibrary.utils;

import com.ld.digitallibrary.dto.item.ReturnableItemDTO;
import com.ld.digitallibrary.dto.item.SavableItemDTO;
import com.ld.digitallibrary.entity.Item;
import org.modelmapper.ModelMapper;

public class ItemMapper {

    public static ReturnableItemDTO mapItemToReturnableDTO(Item item) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(item, ReturnableItemDTO.class);
    }

    public static Item mapSavableDTOtoItem(SavableItemDTO savableItemDTO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(savableItemDTO, Item.class);
    }

}
