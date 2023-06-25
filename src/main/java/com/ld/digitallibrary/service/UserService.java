package com.ld.digitallibrary.service;

import com.ld.digitallibrary.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();
}
