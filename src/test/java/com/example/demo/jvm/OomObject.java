package com.example.demo.jvm;

import java.util.ArrayList;
import java.util.List;

public class OomObject {

    public byte[] placeholder = new byte[64*1024];

    public static void fileHeap(int num) throws InterruptedException {

        List<OomObject> list = new ArrayList<>();

        for(int i = 0;i < num;i++) {
            System.out.println("=========" + i+ "=========");
            Thread.sleep(100);
            list.add(new OomObject());
        }
        System.gc();
        System.out.println("============= END ================");
    }

    public static void main(String[] args) throws InterruptedException {
        fileHeap(1000);
    }
}
