package com.example.Spring_API.api.controller;


import com.example.Spring_API.api.model.User;
import com.example.Spring_API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam Integer id){
        Optional user = userService.getUser(id);
        if(user.isPresent()){
            return (User) user.get();
        }
        return null ;
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        if (createdUser != null) {
            return "Success";
        } else {
            return "Not Success";
        }
    }

    @PutMapping("/user")
    public String updateUser(@RequestParam Integer id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return "Success";
        } else {
            return "Not Success";
        }
    }

    @DeleteMapping("/user")
    public String deleteUser(@RequestParam Integer id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return "Success";
        } else {
            return "Not Success";
        }
    }
}
