package com.example.demo.task;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Task1 {

    public static void main(String[] args) {

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Now time:\t" + new Date() + "\t" + Thread.currentThread().getName());
            }
        };
        System.out.println("Now time:\t" + new Date() + "\t" + Thread.currentThread().getName());
        Timer timer = new Timer("timer");
        long delay = 1000L;
        timer.schedule(timerTask, delay);

    }
}
