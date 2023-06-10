package com.example.demo.practice;

public class A {

    static void aa() {
        System.out.println("aa");
    }

    void a() {
        aa();
        System.out.println("a");
    }

    public static void main(String[] args) {
        A a = new A();
        a.a();
    }
}
