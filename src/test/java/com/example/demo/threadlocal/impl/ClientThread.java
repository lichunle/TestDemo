package com.example.demo.threadlocal.impl;

import com.example.demo.threadlocal.Sequence;

/**
 * @ClassName ClientThread
 * @Description TODO
 * @Author ian
 * @Date 2021/2/28 13:57
 * @Version 1.0.0
 **/
public class ClientThread extends Thread {

    private Sequence sequence;

    public ClientThread(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public void run() {
        for(int i = 0;i < 3;i++) {
            System.out.println(Thread.currentThread().getName() + " =>" + sequence.getNumber());
        }
    }
}
