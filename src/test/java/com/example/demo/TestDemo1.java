package com.example.demo;

import com.example.demo.bean.UserInfo;

import java.util.*;

public class TestDemo1 {

    public static void main(String[] args) {

//        List<String> mylist = Arrays.asList("a1","a2","a3","c1");
//
//        System.out.println(mylist.stream().findFirst());
//        System.out.println(mylist.stream().filter(s -> s.startsWith("c")));
        Map<String, String> params = new HashMap<String, String>(2);
        params.put("sceneId", "1");
        params.put("sNumber", "2");
        params.put("sceneStatus", "3");
        params.put("status", "4");

        String value = params.getOrDefault("123","");
        System.out.println(params);
        if(Objects.isNull(value)) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }
}
