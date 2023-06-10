package com.example.demo;

import org.assertj.core.util.Maps;
import sun.misc.Launcher;
import sun.misc.URLClassPath;

import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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
//        Map<Integer, Object> map = new HashMap<>();
//        for(int i = 0;i< 600000000;i++) {
//            map.put(i, new Date());
//        }
//        URL[] paths = Launcher.getBootstrapClassPath().getURLs();
//
//        for(int i = 0;i < paths.length;i++) {
//            System.out.println(paths[i]);
//        }
//        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
//        map.put("", "");
//
        Map<String, String> tMap = new HashMap<>();
        tMap.put("1", "1");
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        for (Integer o : list) {
//            list.remove(o);
//        }
//        int a = 10;
//        System.out.println(Integer.toBinaryString(2-1));
//        System.out.println(Integer.toBinaryString(8-1));
//        System.out.println(Integer.toBinaryString(16-1));
//        System.out.println(Integer.toBinaryString(32-1));

        long len = 1 << 14;
        System.out.println(len);
        String key = "zZ1!.";
        System.out.println(key.hashCode());
        long mod = key.hashCode() % len;
        System.out.println("取模：" + mod);
//        (key.hashCode()) & (len -1);
        System.out.println(115398910 & 16383);

        Hashtable<String, String> table = new Hashtable<>();
        table.put("","");

    }
}
