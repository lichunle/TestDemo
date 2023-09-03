package com.example.demo.practice;


import java.util.*;

public class TestDemo1 {

    public static void main(String[] args) {

        int[] arr = new int[10];
//        for (int i = 0; i < arr.length; i++) {
//            int i1 = arr[i];
//
//        }
//        for (int i : arr) {
//
//        }
        if(arr.length == 5) {}

//        Car car = new Car();
//        car.setBrand("");
////        car.setBrand();
//
//        BigDecimal b = new BigDecimal(8.1);
//        BigDecimal c = new BigDecimal("8.1");
//        System.out.println(b.toString());
//        System.out.println(c.toString());
        String str = "1,5,3,2,3,4,5,1,3";
        cal1(str);
    }

    public static void calculate(String str) {

        String[] array = str.split(",");
        Map<String, Integer> map = new HashMap<>();
        List<Integer> valueList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            }  else {
                map.put(array[i], 1);
            }
        }

        for (Integer num : map.values()) {
            valueList.add(num);
        }
        Collections.sort(valueList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        LinkedHashMap<String, Integer> tMap = new LinkedHashMap<>();
        for (Integer j : valueList) {
            for (String s : map.keySet()) {
                if (j.equals(map.get(s))) {
                    tMap.put(s, j);
                    continue;
                }
            }
        }
        System.out.println(tMap.keySet());
        System.out.println(tMap.values());
    }


    public static void cal1(String str) {

        String[] array = str.split(",");
        Map<String, Integer> map = new HashMap<>();
        List<Integer> valueList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            }  else {
                map.put(array[i], 1);
            }
        }

        Arrays.sort(array, (o1, o2) -> map.get(o1)-map.get(o2));

        System.out.println(Arrays.toString(array));
    }
}
