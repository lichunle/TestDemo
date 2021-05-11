package com.example.demo.serial;

import java.io.Serializable;

/**
 * @Classname User
 * @Description TODO
 * @Date 2021/5/6 15:54
 * @Created by lichunle
 */
public class User implements Serializable {

    private transient int age;

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
