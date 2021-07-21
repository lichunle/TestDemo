package com.example.demo.leetcode;

/**
 * @Classname Demo1
 * @Description
 * @Date 2021/6/8 16:26
 * @Created by lichunle
 */
public class Demo1 {

    public static int lengthOfLongestSubstring(String s) {

        String targetStr = s.substring(0,1);
        for (int i = 1;i < s.length();i++) {

            if(targetStr.indexOf(s.substring(i,i+1)) < 0) {
                targetStr = s.substring(0,i+1);
            }
        }
        return targetStr.length();
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
