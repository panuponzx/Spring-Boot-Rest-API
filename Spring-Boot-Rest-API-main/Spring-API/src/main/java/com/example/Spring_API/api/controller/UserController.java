package com.example.Spring_API.api.controller;


import com.example.Spring_API.api.model.User;
import com.example.Spring_API.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user/get")
    public ResponseEntity<User> getUser(@RequestParam Integer id){
        Optional<User> user = userService.getUser(id);
        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/user/post")
    public ResponseEntity<String> createUsers(@Valid @RequestBody List<User> users) {
        List<User> createdUsers = userService.createUsers(users);
        if (createdUsers != null && !createdUsers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Users created successfully: " + createdUsers.size());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User creation failed for one or more users");
        }
    }

    @PutMapping("/user/put")
    public ResponseEntity<String> updateUser(@RequestParam Integer id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return ResponseEntity.ok("User updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User update failed");
        }
    }

    @DeleteMapping("/user/delete")
    public ResponseEntity<String> deleteUser(@RequestParam Integer id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User deletion failed");
        }
    }
}
