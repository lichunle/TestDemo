package com.example.demo.thread.notify;

public class ThreadB extends Thread{

    private Object lock;
    public ThreadB() {}

    public ThreadB(Object lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        try {
            synchronized (lock) {
                for(int i = 0;i < 10;i++) {
                    MyList.add();
                    if(MyList.size() == 5) {
                        lock.notify();
                        System.out.println(Thread.currentThread().getName() +"已经发出了通知");
                    }
                    System.out.println("添加了" + (i + 1) + "个元素!");
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Object o =new Object();
        ThreadA a = new ThreadA(o);
        ThreadB b = new ThreadB(o);

        a.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.start();
    }
}
