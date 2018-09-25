package com.esc.userarticleapi.controller;

import com.esc.userarticleapi.entity.User;
import com.esc.userarticleapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/age/{age}")
    public List<User> getAllUserByAgeGreaterThan(@PathVariable Integer age) {
        return userService.getAllUserByAgeGreaterThan(age);
    }

    @GetMapping("/color/{color}")
    public List<User> getAllUsersByArticleColor(@PathVariable String color) {
        return userService.getUsersByArticleColor(color);
    }

    @GetMapping("/number/{number}")
    public List<String> getDistinctNamesByArticleNumber(@PathVariable Integer number) {
        return userService.getUserIdByArticleNumberGreaterThan(number);
    }
}
