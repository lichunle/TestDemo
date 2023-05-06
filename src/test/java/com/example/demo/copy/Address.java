package com.example.demo.copy;

import lombok.Data;

public class Address implements Cloneable {

    private String name;


    public Address() {}

    public Address(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 浅拷贝
    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
