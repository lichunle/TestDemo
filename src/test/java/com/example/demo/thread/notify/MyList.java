package com.example.demo.thread.notify;

import java.util.ArrayList;
import java.util.List;

public class MyList {

    private static List<String> list = new ArrayList<>();

    public static void add() {
        list.add("anything");
    }

    public static int size() {
        return list.size();
    }
}
