package com.example.demo.threadlocal;

import java.lang.reflect.Field;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocalTest {

    private ThreadLocal<Integer> count = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
//        ThreadLocalTest testObj = new ThreadLocalTest();
//        testObj.count.set(1);
//
//        System.out.println(testObj.count.get());
//        System.out.println("========================");
//        Thread t1 = new Thread(() -> test("abc", false));
//        t1.start();
//        t1.join();
//        System.out.println("===================gc after=================");
//        Thread t2 = new Thread(() -> test("def", true));
//        t2.start();

        ReentrantLock lock = new ReentrantLock();
        Thread t3 =new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        });
//        t3.run();
        t3.start();
    }

    public synchronized void test(String str, boolean gcFlag) {

        try {
            new ThreadLocal<>().set(str);
            if(gcFlag) {
                System.gc();
            }
            Thread t = Thread.currentThread();
            Class<? extends Thread> clz = t.getClass();
            Field field = clz.getDeclaredField("threadLocals");
            field.setAccessible(true);
            Object ThreadLocalMap = field.get(t);
            Class<?> tlmClass = ThreadLocalMap.getClass();
            Field tableField = tlmClass.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] arr = (Object[]) tableField.get(ThreadLocalMap);
            for (Object o : arr) {
                if (o != null) {
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");
                    Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    valueField.setAccessible(true);
                    referenceField.setAccessible(true);
                    System.out.println(String.format("弱引用key:%s,值:%s", referenceField.get(o), valueField.get(o)));
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
