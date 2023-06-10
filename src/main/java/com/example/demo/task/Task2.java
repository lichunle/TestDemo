package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Task2 {

//    @Scheduled(cron = "1-2 * * * * ? ")
    public void task1() {
        System.out.println("com.example.demo.task running.....");
    }
}
