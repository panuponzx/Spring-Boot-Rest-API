//package com.example.Spring_API.api.controller;
//
//import com.example.Spring_API.api.model.User;
//import com.example.Spring_API.api.service.UserService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Optional;
//
//import static org.hamcrest.Matchers.is;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//
//@WebMvcTest(UserController.class)
//public class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserService userService;
//
//    @Test
//    public void testGetUser() throws Exception {
//        // ข้อมูลผู้ใช้ที่ต้องการสร้าง
//        User user = new User(1, "Messi", 31,"CEO" ,645211111,"messi@gmail.com");
//        // ตั้งค่าการทำงานของ mock เมื่อเรียกใช้ method getUser
//        when(userService.getUser(1)).thenReturn(Optional.of(user));
//
//        // ส่ง HTTP POST request ไปที่ endpoint /user
//        mockMvc.perform(get("/user")
//                        .param("id", "1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("Messi"))
//                .andExpect(jsonPath("$.age").value(31));
//    }
//
//    @Test
//    public void testCreateUser() throws Exception {
//        // ข้อมูลผู้ใช้ที่ต้องการสร้าง
//        User newUser = new User(10, "Neymar", 29,"Employee",1111111, "neymar@gmail.com");
//
//        // ตั้งค่าการทำงานของ mock เมื่อเรียกใช้ method createUser
//        when(userService.createUser(any(User.class))).thenReturn(newUser);
//
//        // ส่ง HTTP POST request ไปที่ endpoint /user
//        mockMvc.perform(post("/user")
//                        .contentType(MediaType.APPLICATION_JSON) // กำหนด Content-Type เป็น JSON
//                        .content("{\"id\":10,\"name\":\"Neymar\",\"age\":29,\"email\":\"neymar@gmail.com\"}")) // ข้อมูลที่ส่งไปใน request body
//                .andExpect(status().isOk()) // ตรวจสอบว่า HTTP status เป็น 200 OK
//                .andExpect(content().string("Success")); // ตรวจสอบว่า response body เป็น "Success"
//    }
//
//    @Test
//    public void testUpdateUser() throws Exception{
//
//        // ข้อมูลผู้ใช้ที่ต้องการอัปเดต
//        User updateUser = new User(1,"Messi",32,"CEO",645,"messi@gmail.com");
//
//        // ตั้งค่าการทำงานของ mock เมื่อเรียกใช้ method updateUser
//        when(userService.updateUser(eq(1),any(User.class))).thenReturn(updateUser);
//
//        // ส่ง HTTP PUT request ไปที่ endpoint /user
//        // ส่ง HTTP PUT request ไปที่ endpoint /user
//        mockMvc.perform(put("/user")
//                        .param("id", "1") // ส่งพารามิเตอร์ id
//                        .contentType(MediaType.APPLICATION_JSON) // กำหนด Content-Type เป็น JSON
//                        .content("{\"name\":\"Messi\",\"age\":32,\"email\":\"messi_updated@gmail.com\"}")) // ข้อมูลที่ส่งไปใน request body
//                .andExpect(status().isOk()) // ตรวจสอบว่า HTTP status เป็น 200 OK
//                .andExpect(content().string("Success")); // ตรวจสอบว่า response body เป็น "Success"
//    }
//
//    @Test
//    public void testDeleteUser() throws Exception{
//
//        User deleteUser = new User(1,"Messi",32,"CEO",6452111 ,"messi@gmail.com");
//        // ตั้งค่าการทำงานของ mock เมื่อเรียกใช้ method deleteUser
//        when(userService.deleteUser(1)).thenReturn(true);
//
//        // ส่ง HTTP DELETE request ไปที่ endpoint /user
//        mockMvc.perform(delete("/user")
//                .param("id","1"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Success"));
//    }
//
//}
//
