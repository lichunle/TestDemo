package com.example.demo.bishi;

import java.util.HashMap;
import java.util.Map;

public class Demo2 {

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();

        Integer a = new Integer(128);
        Integer b = Integer.valueOf(128);
        System.out.println(a);
        System.out.println(b);
        int c = a++;
        int d = ++b;
        System.out.println(a);
        System.out.println(c);
        System.out.println("=============================");
        System.out.println(b);
        System.out.println(d);

        int m = 3 << 1;
        System.out.println(m);

        int n = 8 >> 1;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(-1));

        char cc = 'a';

        edit("hello", "ian lee");
//        Byte t1 = Byte.valueOf(100);

        long l = Long.MAX_VALUE;
        System.out.println(l + 1 == Long.MIN_VALUE);


    }

    public static void edit(String ... args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}
