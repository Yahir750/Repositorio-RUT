package com.ReUseTech.com.ReUseTech.controller;

import com.ReUseTech.com.ReUseTech.model.User;
import com.ReUseTech.com.ReUseTech.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/insert")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}