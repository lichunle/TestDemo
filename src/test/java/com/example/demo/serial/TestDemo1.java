package com.example.demo.serial;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.UUID;

/**
 * @Classname TestDemo1
 * @Description
 * @Date 2021/5/6 15:54
 * @Created by lichunle
 */
public class TestDemo1 {

    public static void serialUser() throws IOException {
        User user = new User();
        user.setAge(18);
        user.setName("monika");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D://download//1.txt"));
        out.writeObject(user);
        out.close();
        System.out.println("序列化完成");
    }

    private static void deSerialUser() throws IOException, ClassNotFoundException {
        File file = new File("D://download//1.txt");
        ObjectInputStream ios = new ObjectInputStream(new FileInputStream(file));
        User user = (User) ios.readObject();
        System.out.println("age:" + user.getAge() + "\tname:" + user.getName());
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        deSerialUser();
        String key = UUID.randomUUID().toString();
        System.out.println(key);
    }
}
