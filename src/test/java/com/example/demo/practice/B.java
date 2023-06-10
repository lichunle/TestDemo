package com.example.demo.practice;

public class B extends A {

    void b() {
        super.aa();
        super.a();
    }

    public static void main(String[] args) {
        new B().b();
    }
}
