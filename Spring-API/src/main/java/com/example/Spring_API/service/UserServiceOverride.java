package com.example.Spring_API.service;

import com.example.Spring_API.api.model.User;

import java.util.Optional;

public interface UserServiceOverride {
    Optional getUser(Integer id);

    User createUser(User user);

    User updateUser(int id, User user);

    boolean deleteUser(int id);
}
