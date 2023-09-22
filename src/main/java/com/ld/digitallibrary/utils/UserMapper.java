package com.ld.digitallibrary.utils;

import com.ld.digitallibrary.dto.user.ReturnableUserDTO;
import com.ld.digitallibrary.dto.user.SavableUserDTO;
import com.ld.digitallibrary.entity.User;
import org.modelmapper.ModelMapper;

public class UserMapper {

    public static ReturnableUserDTO mapUserToReturnableDTO(User user) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(user, ReturnableUserDTO.class);
    }

    public static User mapSavableDTOToUser(SavableUserDTO savableUserDTO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(savableUserDTO, User.class);
    }

}
