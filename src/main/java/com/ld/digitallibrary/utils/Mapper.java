package com.ld.digitallibrary.utils;

import com.ld.digitallibrary.dto.ItemDTO;
import com.ld.digitallibrary.dto.UserDTO;
import com.ld.digitallibrary.entity.Item;
import com.ld.digitallibrary.entity.User;
import org.modelmapper.ModelMapper;

public class Mapper {

    public static UserDTO mapUserToUserDTO(User user) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(user, UserDTO.class);
    }

    public static ItemDTO mapItemToItemDTO(Item item) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(item, ItemDTO.class);
    }
}
