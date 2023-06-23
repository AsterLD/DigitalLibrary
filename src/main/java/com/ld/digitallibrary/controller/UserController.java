package com.ld.digitallibrary.controller;

import com.ld.digitallibrary.entity.User;
import com.ld.digitallibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/all")
    public List<User> allUsers() {
        return userService.findAll();
    }

}
