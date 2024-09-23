package com.example.Spring_API.api.service;


import com.example.Spring_API.api.model.User;
import com.example.Spring_API.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService implements UserServiceOverride {

    @Autowired
    private UserRepository userRepository;

    //GER USER ID
    @Override
    public Optional<User> getUser(Integer id) {
        return userRepository.findById(id);
    }

    // CREATE USER
    @Override
    public User createUser(User user) {
        if (userRepository.existsById(user.getId())) {
            throw new IllegalArgumentException("User with id" + user.getId()+ "already exists");
        }
        return userRepository.save(user);
    }

    // UPDATE USER
    public User updateUser(int id, User user) {
        Optional<User> existingUserOpt = userRepository.findById(id);

        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            existingUser.setName(user.getName());
            existingUser.setAge(user.getAge());
            existingUser.setEmail(user.getEmail());
            existingUser.setStatus(user.getStatus());
            existingUser.setPhone(user.getPhone());
            return userRepository.save(existingUser); // Save updated to base
        } else {
            throw new NoSuchElementException("User with id " + id + " not found");
        }
    }

    //DELETE USER
    public boolean deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            throw new NoSuchElementException("User with id " + id + " not found");
        }
    }
}
