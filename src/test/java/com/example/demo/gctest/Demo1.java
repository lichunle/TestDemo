package com.example.demo.gctest;

import java.lang.reflect.Method;

public class Demo1 {

    public static void main(String[] args) {

        byte[] b1,b2;
        b1 = new byte[33280*1024];
//        b2 = new byte[900*1024];
        Class clazz = Demo1.class;
        Method[] methods = clazz.getMethods();
        System.out.println(methods);

    }

    public void test1(){}
}
