package com.example.demo.flowcontrol;

import com.google.common.util.concurrent.RateLimiter;

public class Demo1 {

    public static void main(String[] args) {

        RateLimiter rateLimiter = RateLimiter.create(5);

        for(int i = 0;i < 10;i++) {
            double sleepTime = rateLimiter.acquire(1);
            System.out.printf("get 1 tokens: %ss%n", sleepTime);
        }
    }
}
