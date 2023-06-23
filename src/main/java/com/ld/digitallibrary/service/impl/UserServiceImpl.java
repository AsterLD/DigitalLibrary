package com.ld.digitallibrary.service.impl;

import com.ld.digitallibrary.entity.User;
import com.ld.digitallibrary.repo.UserRepository;
import com.ld.digitallibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
