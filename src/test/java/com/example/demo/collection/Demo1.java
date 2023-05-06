package com.example.demo.collection;

import java.util.*;

public class Demo1 {

    public static void main(String[] args) {


        Person p1 = new Person("zhangsan", 1);
        Person p2 = new Person("zhangsan", 1);
        Person p3 = new Person("lisi", 1);

        HashSet set = new HashSet();
        set.add(p1);
        set.add(p2);
        set.add(p3);

        // 比较p1 和 p2， 并打印它们的hashCode()
        System.out.printf("p1.equals(p2) : %s; p1(%d) p2(%d)\n", p1.equals(p2), p1.hashCode(), p2.hashCode());
        // 比较p1 和 p4， 并打印它们的hashCode()
        System.out.printf("p1.equals(p4) : %s; p1(%d) p3(%d)\n", p1.equals(p3), p1.hashCode(), p3.hashCode());
        // 打印set
        System.out.printf("set:%s\n", set.toString());

        List list = new ArrayList<>();

        Map map = new HashMap();
    }
}
