package com.example.demo.practice;

public class C {

    public static int a;

    public C() {
        a = 3;
        System.out.println(a);
    }

    static {
        a = 6;
        System.out.println(a);
    }

    {
        a = 4;
        System.out.println(a);
    }

    public static void main(String[] args) {
        new C();
//        new D();
    }


}
class D extends C {

    static {
        a = 5;
        System.out.println(a);
    }

    {
        a = 2;
        System.out.println(a);
    }


    public D() {
        a = 1;
        System.out.println(a);
    }
}
