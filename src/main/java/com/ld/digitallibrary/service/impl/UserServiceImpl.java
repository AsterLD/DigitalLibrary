package com.ld.digitallibrary.service.impl;

import com.ld.digitallibrary.dto.user.ReturnableUserDTO;
import com.ld.digitallibrary.dto.user.SavableUserDTO;
import com.ld.digitallibrary.entity.User;
import com.ld.digitallibrary.repo.UserRepository;
import com.ld.digitallibrary.service.UserService;
import com.ld.digitallibrary.utils.Updater;
import com.ld.digitallibrary.utils.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ReturnableUserDTO createUser(SavableUserDTO savableUserDTO) {
        User user = UserMapper.mapSavableDTOToUser(savableUserDTO);
        userRepository.save(user);
        log.info("User with id: " + user.getId() + " has been saved");
        return UserMapper.mapUserToReturnableDTO(user);
    }

    @Override
    public List<ReturnableUserDTO> findAll(Integer page, Integer pageSize) {
        List<User> userList = userRepository.findAll(PageRequest.of(page -1, pageSize)).getContent();
        return userList.stream().map(UserMapper::mapUserToReturnableDTO).collect(Collectors.toList());
    }

    @Override
    public ReturnableUserDTO findUserById(long id) {
        User user = userRepository.findById(id).orElseThrow();
        return UserMapper.mapUserToReturnableDTO(user);
    }

    @Override
    public ReturnableUserDTO updateUserById(ReturnableUserDTO returnableUserDTO, long id) {
        User user = userRepository.findById(id).orElseThrow();
        Updater.updateUser(user, returnableUserDTO);
        userRepository.save(user);
        log.info("User with id: " + user.getId() + " has been updated");
        return UserMapper.mapUserToReturnableDTO(user);
    }

    @Override
    public void deleteUserById(long id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
        log.info("User, id: " + id + " has been deleted");
    }
}
