package com.example.demo.collection;

import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class Demo2 {

//    public static void main(String[] args) throws Exception {
//
//        MyStack stack = new MyStack();
//        stack.push(1);
//        stack.push(2);
//        stack.print();
//
//        stack.pop();
//        stack.print();
//
//        System.out.println(stack.isEmpty());
//        System.out.println(stack.isFull());
//    }

}

class MyStack {

    private int maxSize;

    private long[] array;

    private int top;


    public void push(long node) {

        if (array == null) {
            array = new long[100];
            top = -1;
            maxSize = 0;
        }
        array[top + 1] = node;
        maxSize++;
        top++;
    }

    public long pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("22");
        }
        long s = array[top];
        array[top] = 0;
        return s;
    }

    public long peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("22");
        }
        return array[top];
    }

    public boolean isEmpty() {
        if (array == null || 0 == maxSize) {
            return true;
        }

        return false;
    }

    public boolean isFull() {
        if (isEmpty()) {
            return false;
        }
        if (maxSize == (top+1)) {
            return true;
        }
        return false;
    }

    public void print() {
        System.out.println(Arrays.toString(array));
    }

    public int getTop() {
        return top;
    }
}
