package com.ld.digitallibrary.service;

import com.ld.digitallibrary.dto.user.ReturnableUserDTO;
import com.ld.digitallibrary.dto.user.SavableUserDTO;

import java.util.List;

public interface UserService {

    ReturnableUserDTO createUser(SavableUserDTO savableUserDTO);

    List<ReturnableUserDTO> findAll(Integer page, Integer pageSize);

    ReturnableUserDTO findUserById(long itemId);

    ReturnableUserDTO updateUserById(ReturnableUserDTO returnableUserDTO, long id);

    void deleteUserById(long itemId);
}
