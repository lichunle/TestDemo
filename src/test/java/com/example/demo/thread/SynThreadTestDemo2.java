package com.example.demo.thread;

/**
 * @Classname SynThreadDemo2
 * @Description TODO
 * @Date 2021/1/15 16:53
 * @Created by lichunle
 */
public class SynThreadTestDemo2 {

    public static void main(String[] args) {
        SynThread1 synThread1 = new SynThread1();
//        for(int i = 0;i < 5;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                        synThread1.getB();
                    }

            },"Thread1").start();
//        }
//        for(int i = 0;i < 5;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synThread1.getA();
                }
            },"Thread2").start();
//        }
    }


}
class SynThread1 {
    private static int count;
    public SynThread1() {
        count = 0;
    }
    public void getA() {
//        for(int i = 0;i < 5;i++) {
            System.out.println("线程名:"+Thread.currentThread().getName() + ":" + (count++));
//        }
    }


    public void getB() {
        Object obj = new Object();
//        synchronized (this) {
//            for(int i = 0;i < 5;i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程名:" + Thread.currentThread().getName() + ":" + (count++));
//            }
//        }
    }
}
