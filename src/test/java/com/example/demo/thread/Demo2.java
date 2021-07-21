package com.example.demo.thread;

/**
 * @Classname Demo2
 * @Description
 * @Date 2021/6/10 15:06
 * @Created by lichunle
 */
public class Demo2 extends Thread {


    @Override
    public void run() {
        System.out.println("Demo2.............");
    }

    public static void main(String[] args) {

        Thread demo = new Demo2();
        demo.start();
    }
}
