package com.ld.digitallibrary.utils;

import com.ld.digitallibrary.dto.GroupDTO;
import com.ld.digitallibrary.dto.GroupWithUsersDTO;
import com.ld.digitallibrary.dto.ItemDTO;
import com.ld.digitallibrary.dto.UserDTO;
import com.ld.digitallibrary.entity.Group;
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

    public static GroupDTO mapGroupToGroupDTO(Group group) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(group, GroupDTO.class);
    }

    public static GroupWithUsersDTO mapGroupToGroupWithUsersDTO(Group group) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(group, GroupWithUsersDTO.class);
    }

    public static Group mapGroupDTOToGroup(GroupDTO groupDTO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(groupDTO, Group.class);
    }

    public static void updateGroup(Group group, GroupDTO groupDTO) {
        if (Objects.nonNull(groupDTO)) {
            if (Objects.nonNull(groupDTO.getName())) {
                group.setName(groupDTO.getName());
            }
        }
    }
}
