package com.example.Spring_API.api.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    /**
     * ทดสอบการสร้าง User object และการใช้งาน getter methods
     * ทดสอบนี้จะตรวจสอบว่า User object ถูกสร้างและกำหนดค่าถูกต้องตามที่คาดหวังหรือไม่
     */
    @Test
    public void testUserConstructorAndGetters() {
        User user = new User(1, "Messi", 31, "CEO",645211111,"messi@gmail.com");

        // ตรวจสอบว่า constructor และ getter methods ทำงานได้ตามที่คาดหวัง
        assertEquals(1, user.getId(), "ID ควรเป็น 1");
        assertEquals("Messi", user.getName(), "ชื่อควรเป็น 'Messi'");
        assertEquals(31, user.getAge(), "อายุควรเป็น 31");
        assertEquals("messi@gmail.com", user.getEmail(), "อีเมลควรเป็น 'messi@gmail.com'");
    }

    /**
     * ทดสอบ setter methods ของ User class
     * ทดสอบนี้จะตรวจสอบว่า setter methods สามารถอัปเดตค่า fields ของ User object ได้ถูกต้องหรือไม่
     */
    @Test
    public void testSetters() {
        User user = new User(1, "Messi", 31, "CEO",645211111,"messi@gmail.com");

        // อัปเดตค่า fields ของ user โดยใช้ setter methods
        user.setId(2);
        user.setName("Ronaldo");
        user.setAge(34);
        user.setEmail("ronaldo@gmail.com");

        // ตรวจสอบว่าค่า fields ถูกอัปเดตอย่างถูกต้อง
        assertEquals(2, user.getId(), "ID ควรถูกอัปเดตเป็น 2");
        assertEquals("Ronaldo", user.getName(), "ชื่อควรถูกอัปเดตเป็น 'Ronaldo'");
        assertEquals(34, user.getAge(), "อายุควรถูกอัปเดตเป็น 34");
        assertEquals("ronaldo@gmail.com", user.getEmail(), "อีเมลควรถูกอัปเดตเป็น 'ronaldo@gmail.com'");
    }

    /**
     * ทดสอบความเท่ากันของ User objects ที่มีข้อมูลเดียวกัน
     * ทดสอบนี้จะตรวจสอบว่า User objects ที่มีข้อมูลเหมือนกันจะถือว่ามีความเท่ากัน
     */
    @Test
    public void testUserEquality() {
        User user1 = new User(1, "Messi", 31, "CEO",64521111,"messi@gmail.com");
        User user2 = new User(1, "Messi", 31, "CEO",64521111,"messi@gmail.com");

        // ตรวจสอบว่า User objects ที่มีข้อมูลเดียวกันถือว่ามีความเท่ากัน
        assertEquals(user1.getId(), user2.getId(), "ID ควรเท่ากัน");
        assertEquals(user1.getName(), user2.getName(), "ชื่อควรเท่ากัน");
        assertEquals(user1.getAge(), user2.getAge(), "อายุควรเท่ากัน");
        assertEquals(user1.getEmail(), user2.getEmail(), "อีเมลควรเท่ากัน");
    }

    /**
     * ทดสอบความแตกต่างระหว่าง User objects ที่มีข้อมูลต่างกัน
     * ทดสอบนี้จะตรวจสอบว่า User objects ที่มีข้อมูลต่างกันจะต้องไม่ถือว่ามีความเท่ากัน
     */
    @Test
    public void testUserNotEqual() {
        User user1 = new User(1, "Messi",31, "CEO",64521111,"messi@gmail.com");
        User user2 = new User(2, "Ronaldo", 34,"Employee",6452133,"ronaldo@gmail.com");

        // ตรวจสอบว่า fields ต่าง ๆ ของ User objects ที่มีข้อมูลต่างกันไม่เท่ากันตามที่คาดหวัง
        assertEquals(user1.getId(), 1, "ID ของ user1 ควรเป็น 1");
        assertEquals(user2.getId(), 2, "ID ของ user2 ควรเป็น 2");
        assertEquals(user1.getName(), "Messi", "ชื่อของ user1 ควรเป็น 'Messi'");
        assertEquals(user2.getName(), "Ronaldo", "ชื่อของ user2 ควรเป็น 'Ronaldo'");
        assertEquals(user1.getAge(), 31, "อายุของ user1 ควรเป็น 31");
        assertEquals(user2.getAge(), 34, "อายุของ user2 ควรเป็น 34");
        assertEquals(user1.getEmail(), "messi@gmail.com", "อีเมลของ user1 ควรเป็น 'messi@gmail.com'");
        assertEquals(user2.getEmail(), "ronaldo@gmail.com", "อีเมลของ user2 ควรเป็น 'ronaldo@gmail.com'");
    }
}
