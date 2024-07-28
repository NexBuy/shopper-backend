package com.project.shopper.controller;


import java.util.List;

import com.project.shopper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.shopper.model.ProductUser;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseBody
    public List<ProductUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ProductUser getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PatchMapping()
    @ResponseBody
    public ProductUser updateUser(@RequestBody ProductUser user){
        return userService.updateUser(user);
    }

    @PostMapping
    @ResponseBody
    public ProductUser createUser(@RequestBody ProductUser user) {
    	System.out.println(user.getFirstName());
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

