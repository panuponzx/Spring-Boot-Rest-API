package com.example.Spring_API.service;

import com.example.Spring_API.api.model.User;
import com.example.Spring_API.api.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setup() {
        userService = new UserService();
    }

    @Test
    public void tesGetUserSuccess() {
        Optional<User> user = userService.getUser(1);
        assertTrue(user.isPresent());
        assertEquals(1, user.get().getId());
        assertEquals("Messi", user.get().getName());
    }

    @Test
    public void testGetUserNotFound() {
        Optional<User> user = userService.getUser(100);
        assertFalse(user.isPresent());
    }

    @Test
    public void testCreateUserSuccess() {
        User newUser = new User(12,"Neymar",31,"Employee",6452111,"neymar@gmail.com");
        User createUser = userService.createUser(newUser);
        assertNotNull(createUser);
        assertEquals(12,createUser.getId());
        assertEquals("Neymar",createUser.getName());
    }

    @Test
    public void testCreateUserAlreadyExists(){
        User existingUser = new User(1,"Messi",32,"CEO",64521111,"messi@gamil.com");
        assertThrows(IllegalArgumentException.class, () -> userService.createUser(existingUser));
    }

    @Test
    public void testUpdateUserSuccess() {
        User updateuser = new User(1,"Messi",35,"CEO",64521111,"messi32@gmail.com");
        User result = userService.updateUser(1,updateuser);
        assertNotNull(result);
        assertEquals(35,result.getAge());
        assertNotNull("messi@gmail.com",result.getEmail());
    }

    @Test
    public void testDeleteUserSuccess() {
        boolean result = userService.deleteUser(1);
        assertTrue(result);
        assertThrows(NoSuchElementException.class, () -> userService.getUser(1).get());
    }

    @Test
    public void testDeleteUserNotFound() {
        assertThrows(NoSuchElementException.class,() -> userService.deleteUser(100));
    }
}
