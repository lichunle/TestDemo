package com.example.demo;


import java.util.concurrent.CountDownLatch;

/**
 * @Classname SynThreadTestDemo1
 * @Description TODO
 * @Date 2021/1/15 16:49
 * @Created by lichunle
 */
public class SynThreadTestDemo1 {

    public static void main(String[] args) {

        CountDownLatch count = new CountDownLatch(2);
        SyncThread syncThread = new SyncThread();
        SyncThread syncThread1 = new SyncThread();
        Thread thread1 = new Thread(syncThread,"syncThread1");
        Thread thread2 = new Thread(syncThread1,"syncThread2");
        thread1.start();
        thread2.start();
    }
}


class SyncThread implements Runnable {
    private static int count;
    public SyncThread() {
        count = 0;
    }
    public void run() {
        synchronized (this){
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("线程名:"+Thread.currentThread().getName() + ":" + count++);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public int getCount() {
        return count;
    }
}