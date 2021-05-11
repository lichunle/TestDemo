package com.example.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname ThreadDemo1
 * @Description TODO
 * @Date 2021/1/18 10:08
 * @Created by lichunle
 */
public class ThreadDemo1 {

    public static void main(String[] args) {

        CountDownLatch count = new CountDownLatch(2);
        ExecutorService executer1 = Executors.newSingleThreadExecutor();
        executer1.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程"+Thread.currentThread().getName()+"执行");
                count.countDown();
            }
        });
        executer1.shutdown();
        ExecutorService executer2 = Executors.newSingleThreadExecutor();
        executer2.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程"+Thread.currentThread().getName()+"执行");
                count.countDown();
            }
        });
        executer2.shutdown();
        System.out.println("等待子线程执行完毕==========");
        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程执行完毕==========");
    }
}
