package com.ld.digitallibrary.service;

import com.ld.digitallibrary.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> findAll();

    UserDTO findUserById(long id);

    UserDTO updateUserById(UserDTO userDTO, long id);

    void deleteUserById(long id);
}
