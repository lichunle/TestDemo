package com.example.demo.lock;

public class ClassLockWorker implements Runnable {
    @Override
    public void run() {

        try {
            ClassLock classLock  = new ClassLock();
            classLock.lockObject();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
