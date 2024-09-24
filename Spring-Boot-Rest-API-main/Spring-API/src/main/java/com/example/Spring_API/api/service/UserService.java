package com.example.Spring_API.api.service;

import com.example.Spring_API.api.model.User;
import com.example.Spring_API.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserServiceOverride {

    @Autowired
    private UserRepository userRepository;

    private final Validator validator;

    public UserService() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    // GET USER BY ID
    @Override
    public Optional<User> getUser(Integer id) {
        return userRepository.findById(id);
    }

    // CREATE USER
    @Override
    public User createUser(User user) {
        validateUser(user); // Validate user before creation
        return userRepository.save(user);
    }

    // CREATE MULTIPLE USERS
    public List<User> createUsers(List<User> users) {
        List<User> createdUsers = new ArrayList<>();
        for (User user : users) {
            validateUser(user); // Validate each user
            createdUsers.add(userRepository.save(user));
        }
        return createdUsers;
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
            return userRepository.save(existingUser);
        } else {
            throw new NoSuchElementException("User with id " + id + " not found");
        }
    }

    // DELETE USER
    public boolean deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            throw new NoSuchElementException("User with id " + id + " not found");
        }
    }

    // Method to validate user
    private void validateUser(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<User> violation : violations) {
                sb.append(violation.getMessage()).append("; ");
            }
            throw new IllegalArgumentException("Validation failed: " + sb.toString());
        }
    }
}
