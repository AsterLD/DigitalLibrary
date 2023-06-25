package com.ld.digitallibrary.service.impl;

import com.ld.digitallibrary.dto.UserDTO;
import com.ld.digitallibrary.entity.User;
import com.ld.digitallibrary.repo.UserRepository;
import com.ld.digitallibrary.service.UserService;
import com.ld.digitallibrary.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDTO> findAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(Mapper::mapUserToUserDTO).collect(Collectors.toList());
    }
}
