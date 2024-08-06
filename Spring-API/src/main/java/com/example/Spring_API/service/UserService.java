package com.example.Spring_API.service;


import com.example.Spring_API.api.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserServiceOverride {

    private final List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1,"Messi",31,"messi@gmail.com");
        User user2 = new User(2,"David",35,"david@gmail.com");
        User user3 = new User(3,"Ronaldo",32,"ronaldo@gmail.com");
        User user4 = new User(4,"Ronny",27,"ronny@gmail.com");
        User user5 = new User(5,"Jackson",22,"jackson@gmail.com");
        User user6 = new User(6,"Macro",43,"Macro@gmail.com");
        User user7 = new User(7,"Tanny",21,"Tanny@gmail.com");
        User user8 = new User(8,"Frank",45,"Frank@gmail.com");
        User user9 = new User(9,"Bobby",41,"Bobby@gmail.com");
        User user11 = new User(11,"Mane",29,"Mane@gmail.com");

        userList.addAll(Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user11));
    }

    @Override
    public Optional getUser(Integer id) {
        Optional optional = Optional.empty();
        for (User user: userList){
            if (id == user.getId()){
                optional = Optional.of(user);
                return optional ;
            }
        }
        return optional;
    }

    @Override
    public User createUser(User user) {
        // ตรวจสอบว่า id ของผู้ใช้ไม่ซ้ำกับที่มีอยู่ใน userList
        for (User existingUser : userList){
            if (existingUser.getId() == user.getId()){
                throw new IllegalArgumentException("User with id " + user.getId() + " already exists");
            }
        }
        userList.add(user);
        return user;
    }

    @Override
    public User updateUser(int id, User user) {
        //ค้นหาผู้ใข้ใน userList
        for (int i = 0; i < userList.size(); i++) {
            User existingUser = userList.get(i);
            if (existingUser.getId() == id) {
                // อัปเดตข้อมูลของผู้ใช้
                existingUser.setName(user.getName());
                existingUser.setAge(user.getAge());
                existingUser.setEmail(user.getEmail());
                return existingUser;
            }
        }
        throw new NoSuchElementException("User with id " + id + " not found");
    }

    @Override
    public boolean deleteUser(int id) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getId() == id) {
                userList.remove(i);
                return userList.removeIf(User -> user.getId() == id);
            }
        }
        throw new NoSuchElementException("User with id " + id + " not found");
    }
}
