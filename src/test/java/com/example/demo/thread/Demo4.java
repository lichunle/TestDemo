package com.example.demo.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo4 {

    public static volatile int a = 0;

    public void incr() {
        synchronized (this) {
            a++;
        }

    }

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        Demo4 demo = new Demo4();
        for (int i = 0; i < 5; i++) {

            threadPoolExecutor.execute(() -> {
                for (int j = 0; j < 500; j++) {
                    demo.incr();
                }
            });

        }
        Thread.sleep(2000);
        System.out.println(a);
        threadPoolExecutor.shutdown();
        Executors.newFixedThreadPool(5);
    }
}
