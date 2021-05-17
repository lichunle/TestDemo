package com.example.demo.threadlocal.impl;

import com.example.demo.threadlocal.Sequence;

/**
 * @ClassName SequenceA
 * @Description TODO
 * @Author ian
 * @Date 2021/2/28 13:55
 * @Version 1.0.0
 **/
public class SequenceA implements Sequence {

    private static int number = 0;

    @Override
    public int getNumber() {
        return number++;
    }

    public static void main(String[] args) {
        Sequence sequence = new SequenceA();
        ClientThread thread1 = new ClientThread(sequence);
        ClientThread thread2 = new ClientThread(sequence);
        ClientThread thread3 = new ClientThread(sequence);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
