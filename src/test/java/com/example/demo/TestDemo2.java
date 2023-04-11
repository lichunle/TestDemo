package com.example.demo;

import org.assertj.core.util.Maps;

import java.util.*;

public class TestDemo2 {

    public static void main(String[] args) {

//        Integer a = 1000;//new Integer(1000);
//        Integer b = 1000;//new Integer(1000);
//        System.out.println(a == b);
//
//        Integer c = 100;
//        Integer d = 100;
//        System.out.println(c == d);
//        Map<String, Object> resultMap = new HashMap<>();
//        System.out.println(resultMap);

//        String[] str = {"A12","A05A21","A13","A15","A04"};
//        List<String> list = Arrays.asList(str);
//        String orgNo = "A01";
//        if(list.contains(orgNo)) {
//            System.out.println("exist====");
//        }
        Map<Integer, Object> map = new HashMap<>();
        for(int i = 0;i< 600000000;i++) {
            map.put(i, new Date());
        }
    }
}
