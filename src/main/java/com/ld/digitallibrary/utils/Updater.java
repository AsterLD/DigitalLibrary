package com.ld.digitallibrary.utils;

import com.ld.digitallibrary.dto.group.ReturnableGroupDTO;
import com.ld.digitallibrary.dto.group.SavableGroupDTO;
import com.ld.digitallibrary.dto.item.SavableItemDTO;
import com.ld.digitallibrary.dto.user.ReturnableUserDTO;
import com.ld.digitallibrary.entity.Group;
import com.ld.digitallibrary.entity.Item;
import com.ld.digitallibrary.entity.User;

import java.util.Objects;

public class Updater {

    public static void updateUser(User user, ReturnableUserDTO returnableUserDTO) {
        if (Objects.nonNull(returnableUserDTO)) {
            if (Objects.nonNull(returnableUserDTO.getUsername())) {
                user.setUsername(returnableUserDTO.getUsername());
            }
        }
    }

    public static void updateItem(Item item, SavableItemDTO savableItemDTO) {
        if (Objects.nonNull(savableItemDTO)) {
            if (Objects.nonNull(savableItemDTO.getName())) {
                item.setName(savableItemDTO.getName());
            }
            if (Objects.nonNull(savableItemDTO.getType())) {
                item.setType(savableItemDTO.getType());
            }
            if (Objects.nonNull(savableItemDTO.getUploadDate())) {
                item.setUploadDate(savableItemDTO.getUploadDate());
            }
        }
    }

    public static void updateGroup(Group group, SavableGroupDTO savableGroupDTO) {
        if (Objects.nonNull( savableGroupDTO)) {
            if (Objects.nonNull(savableGroupDTO.getName())) {
                group.setName( savableGroupDTO.getName());
            }
        }
    }
}
