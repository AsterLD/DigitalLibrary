package com.ld.digitallibrary.service;

import com.ld.digitallibrary.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> findAll(Integer page, Integer pageSize);

    UserDTO findUserById(long itemId);

    UserDTO updateUserById(UserDTO userDTO, long id);

    void deleteUserById(long itemId);
}
