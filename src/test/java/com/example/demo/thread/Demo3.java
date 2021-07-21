package com.example.demo.thread;

/**
 * @Classname Demo3
 * @Description
 * @Date 2021/6/10 15:11
 * @Created by lichunle
 */
public class Demo3 implements Runnable {

    @Override
    public void run() {
        System.out.println("demo3..............");
    }

    public static void main(String[] args) {
        Thread demo3 = new Thread(new Demo3());
        demo3.start();
    }
}
