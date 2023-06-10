package com.example.demo.copy;

import lombok.Data;

import java.util.Optional;

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

    public static void main(String[] args) {

        Address a1 = null;
//        Address copyObj = a1.clone();
//        System.out.println(a1.hashCode() + "\t" + a1.getName());
//        System.out.println(copyObj.hashCode()+ "\t" + copyObj.getName());
        Optional<Address> a11 = Optional.ofNullable(a1);
        System.out.println(a11.isPresent());
    }
}
