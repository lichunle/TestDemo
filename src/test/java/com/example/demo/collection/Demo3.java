package com.example.demo.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo3 {

    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(-1);
        list.add(3);
        list.add(5);
        list.add(-2);
        list.add(-3);
        list.add(8);

//        Collections.sort(list);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        list.stream().forEach((o) -> {
            System.out.println(o.intValue());
        });


    }
}
