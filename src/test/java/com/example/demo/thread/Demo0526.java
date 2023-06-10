package com.example.demo.thread;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

public class Demo0526 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Executors.newCachedThreadPool();
//        executorService.submit();
        ThreadPoolExecutor pools = new ThreadPoolExecutor(5,10,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>(100));
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

    }
}
