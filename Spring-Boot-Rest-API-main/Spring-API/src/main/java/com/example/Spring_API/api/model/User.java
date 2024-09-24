package com.example.Spring_API.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "Age must be at least 0")
    @Max(value = 100, message = "Age must be at most 0")
    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;

    @Size(max = 10, message = "Phone number must be at most 10 characters")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
    @Column(name = "phone")
    private String phone;

    @Column(name = "status")
    private String status;

    // Default no-argument constructor
    public User() {
    }

    // Constructor with parameters
    public User(int id, String name, int age, String status, String phone, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
