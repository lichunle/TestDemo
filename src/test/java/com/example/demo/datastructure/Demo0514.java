package com.example.demo.datastructure;

import java.util.Scanner;

public class Demo0514 {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}
