package com.example.demo.bean;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //第一种方式 dog的说明书
        Class clazz = Dog.class;
        //第二种方式
        Class clazz1 = Class.forName("com.example.demo.bean.Dog");
//
//        Dog dog = new Dog();
//        Class clazz2 = dog.getClass();
//
//        System.out.println(clazz.getName());
//        System.out.println(clazz1);
//        System.out.println(clazz2);
        Dog dog = (Dog)clazz1.newInstance();
        dog.eat("meat");
    }
}
