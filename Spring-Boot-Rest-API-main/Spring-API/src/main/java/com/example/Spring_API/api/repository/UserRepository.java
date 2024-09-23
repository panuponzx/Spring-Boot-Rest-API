package com.example.Spring_API.api.repository;

import com.example.Spring_API.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}