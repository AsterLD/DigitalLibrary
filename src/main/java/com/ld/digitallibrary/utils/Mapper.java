package com.ld.digitallibrary.utils;

import com.ld.digitallibrary.dto.ItemDTO;
import com.ld.digitallibrary.dto.UserDTO;
import com.ld.digitallibrary.entity.Item;
import com.ld.digitallibrary.entity.User;
import org.modelmapper.ModelMapper;

import java.util.Objects;

public class Mapper {

    public static UserDTO mapUserToUserDTO(User user) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(user, UserDTO.class);
    }

    public static User mapUserDTOToUser(UserDTO userDTO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(userDTO, User.class);
    }

    public static void updateUser(User user, UserDTO userDTO) {
        if (Objects.nonNull(userDTO)) {
            if (Objects.nonNull(userDTO.getUsername())) {
                user.setUsername(userDTO.getUsername());
            }
        }
    }

    public static ItemDTO mapItemToItemDTO(Item item) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(item, ItemDTO.class);
    }

    public static Item mapItemDTOtoItem(ItemDTO itemDTO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(itemDTO, Item.class);
    }

    public static void updateItem(Item item, ItemDTO ItemDTO) {
        if (Objects.nonNull(ItemDTO)) {
            if (Objects.nonNull(ItemDTO.getName())) {
                item.setName(ItemDTO.getName());
            }
            if (Objects.nonNull(ItemDTO.getType())) {
                item.setType(ItemDTO.getType());
            }
            if (Objects.nonNull(ItemDTO.getUploadDate())) {
                item.setUploadDate(ItemDTO.getUploadDate());
            }
        }
    }
}
