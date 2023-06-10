package com.example.demo.datastructure;

import java.util.*;

public class Demo2 {

    public static void main(String[] args) {
        isValid("{}");
    }

    public static boolean isValid (String s) {
        // write code here
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i < s.length();i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

//    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
//
//    }
}
