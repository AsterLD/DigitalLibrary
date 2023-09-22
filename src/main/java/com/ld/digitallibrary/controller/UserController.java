package com.ld.digitallibrary.controller;

import com.ld.digitallibrary.dto.user.ReturnableUserDTO;
import com.ld.digitallibrary.dto.user.SavableUserDTO;
import com.ld.digitallibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ReturnableUserDTO createUser(@RequestBody SavableUserDTO savableUserDTO) {
        return userService.createUser(savableUserDTO);
    }

    @GetMapping("/user/all")
    public List<ReturnableUserDTO> getAllUsers(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return userService.findAll(page, pageSize);
    }

    @GetMapping("/user/{id}")
    public ReturnableUserDTO getUserById(@PathVariable("id") Long userId) {
        return userService.findUserById(userId);
    }

    @PutMapping(value = "/user/{id}/update")
    public ReturnableUserDTO updateUserById(@PathVariable("id") Long userId, @RequestBody ReturnableUserDTO returnableUserDTO) {
        return userService.updateUserById(returnableUserDTO, userId);
    }

    @DeleteMapping("/user/{id}/delete")
    public long deleteUserById(@PathVariable("id") Long userId) {
        userService.deleteUserById(userId);
        return userId;
    }

}
