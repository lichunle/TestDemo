package com.example.demo.lock;

public class ClassLock {

    private static Object lock = new Object();

    public static synchronized void methodLock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(5*1000);
    }

    public void lockClass() throws InterruptedException {
        synchronized (ClassLock.class) {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10*1000);
        }
    }

    public void lockObject() throws InterruptedException {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10*1000);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new ClassLockWorker());
            t.setName("kite\t" + i);
            t.start();
        }
    }
}
