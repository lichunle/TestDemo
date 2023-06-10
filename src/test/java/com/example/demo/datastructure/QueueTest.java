package com.example.demo.datastructure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;

public class QueueTest {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        Deque<String> deque = new LinkedList<>();

//        BlockingQueue
//        ThreadPoolExecutor pools = new ThreadPoolExecutor(5,10, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

        System.out.println(0x7fffffff);
        long len = 1 << 32 -1;
        System.out.println(len);
    }

    public void testArrayBlockingQueue() {

        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(10);

    }

    public void testLinkedBlockingQueue() {
        LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();
    }

    public void testPriorutyBlockingQueue() {

        PriorityBlockingQueue<String> queue = new PriorityBlockingQueue<>();
    }
}
