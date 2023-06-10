package com.example.demo.datastructure;

import java.util.Stack;

public class Demo0518 {

    public static void main(String[] args) {

//        String str = " B c ";
//        String[] ss = str.split(" ");
//        System.out.println((char)(str.charAt(0) - 'A' + 'a'));
//        str.toLowerCase();
//        StringBuffer sBuffer = new StringBuffer("");
//        sBuffer.reverse();
//        System.out.println(change(81));
        String str = "0xfff";
        int a = Integer.parseInt(str.substring(2), 16);
        System.out.println(a);
    }



    public static int change(int m) {
        int n = 0;

        while(true) {
            int i = m / 3;
            int j = m % 3;
            n += i;
            if ((i + j) < 3) {
                if ((i + j) == 2) {
                    n = n +1;
                }
                break;
            } else {
                m = i + j;
            }
        }
        return n;
    }
}
