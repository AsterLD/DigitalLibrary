package com.ld.digitallibrary.service.impl;

import com.ld.digitallibrary.dto.UserDTO;
import com.ld.digitallibrary.entity.User;
import com.ld.digitallibrary.repo.UserRepository;
import com.ld.digitallibrary.service.UserService;
import com.ld.digitallibrary.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = Mapper.mapUserDTOToUser(userDTO);
        userRepository.save(user);
        return Mapper.mapUserToUserDTO(user);
    }

    @Override
    public List<UserDTO> findAll(Integer page, Integer pageSize) {
        List<User> userList = userRepository.findAll(PageRequest.of(page -1, pageSize)).getContent();
        return userList.stream().map(Mapper::mapUserToUserDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO findUserById(long id) {
        User user = userRepository.findById(id).orElseThrow();
        return Mapper.mapUserToUserDTO(user);
    }

    @Override
    public UserDTO updateUserById(UserDTO userDTO, long id) {
        User user = userRepository.findById(id).orElseThrow();
        Mapper.updateUser(user, userDTO);
        userRepository.save(user);
        return Mapper.mapUserToUserDTO(user);
    }

    @Override
    public void deleteUserById(long id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }
}
