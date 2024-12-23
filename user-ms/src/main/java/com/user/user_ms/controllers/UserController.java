package com.user.user_ms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.user_ms.entities.User;
import com.user.user_ms.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/find")
    public User findById(@RequestParam Long id) {
        return userService.findById(id);
    }

    @GetMapping("/save")
    public User save(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        User user = User.builder().name(name).email(email).password(password).build();
        return userService.save(user);
    }

    @GetMapping("/delete")
    public void deleteById(@RequestParam Long id) {
        userService.deleteById(id);
    }
}
