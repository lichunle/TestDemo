package com.example.demo.thread.notify;

public class ThreadA extends Thread {

    private Object lock;
    public ThreadA() {}

    public ThreadA(Object lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        try {
            synchronized (lock) {
                if(MyList.size() != 5) {
                    System.out.println(Thread.currentThread().getName() + "wait begin "  + System.currentTimeMillis());
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + "wait end  " +System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
