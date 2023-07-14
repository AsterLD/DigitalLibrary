package com.ld.digitallibrary.controller;

import com.ld.digitallibrary.dto.UserDTO;
import com.ld.digitallibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping("/user/all")
    public List<UserDTO> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable("id") Long userId) {
        return userService.findUserById(userId);
    }

    @PutMapping(value = "/user/{id}/update")
    public UserDTO updateUserById(@PathVariable("id") Long userId, @RequestBody UserDTO userDTO) {
        return userService.updateUserById(userDTO, userId);
    }

    @DeleteMapping("/user/{id}/delete")
    public long deleteUserById(@PathVariable("id") Long userId) {
        userService.deleteUserById(userId);
        return userId;
    }

}
