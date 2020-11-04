package com.example.demo.bean;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

    public void run() {
        Lock lock = new ReentrantLock();
        lock.tryLock();
        System.out.println("locking .....");
        lock.unlock();
    }

}
