package com.example.demo.lock;

public class ObjectLock {

    private Object lock = new Object();


    public void lockObjectFiled() throws InterruptedException {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10*1000);
        }
    }

    public void lockThis() throws InterruptedException {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10*1000);
        }
    }

    public synchronized void lockMethod() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(10*1000);
    }

    public static void main(String[] args) {
        ObjectLockWorker oo = new ObjectLockWorker();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(oo);
            t.setName("kite\t" + i);
            t.start();
        }
    }
}

class ObjectLockWorker implements Runnable{


    @Override
    public void run() {
        try {
            ObjectLock objectLock = new ObjectLock();
//            objectLock.lockObjectFiled();
//            objectLock.lockThis();
            objectLock.lockMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
