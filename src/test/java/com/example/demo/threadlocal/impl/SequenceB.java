package com.example.demo.threadlocal.impl;

import com.example.demo.threadlocal.Sequence;

/**
 * @ClassName SequenceB
 * @Description TODO
 * @Author ian
 * @Date 2021/2/28 14:02
 * @Version 1.0.0
 **/
public class SequenceB implements Sequence {

    private static ThreadLocal<Integer> number = new ThreadLocal<Integer>() {

        protected Integer initialValue() {
            return 0;
        }
    };

    @Override
    public int getNumber() {
        number.set(number.get() + 1);
        return number.get();
    }
    public static void main(String[] args) {
        Sequence sequence = new SequenceB();
        ClientThread thread1 = new ClientThread(sequence);
        ClientThread thread2 = new ClientThread(sequence);
        ClientThread thread3 = new ClientThread(sequence);


        ClientThread thread4 = new ClientThread(sequence);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
