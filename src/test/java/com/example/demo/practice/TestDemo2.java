package com.example.demo.practice;

public class TestDemo2 {

    public static void main(String[] args) {

//        System.out.println(jumpFloor(3));
        String str = "Hello World";
        String str1 = "Hel";
//        System.out.println(trans(str, 11));
//        System.out.println(getCommonPrefix(str, str1));
        String ss = "1000";
        char[] chars = ss.toCharArray();
        System.out.println(Integer.parseInt(chars[0]+""));
    }

    public static int jumpFloor(int target) {
        if (target <= 1) {
            return 1;
        }
        return jumpFloor(target-1) + jumpFloor(target -2);
    }

    public static String trans(String s, int n) {
        // write code here
        if (n == 0) {
            return s;
        }
        StringBuffer sBuffer = new StringBuffer("");
        for(int i = 0;i < n;i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sBuffer.append((char)(c-'A' + 'a'));
            } else if (c >= 'a' && c <= 'z') {
                sBuffer.append((char)(c-'a' + 'A'));
            } else {
                sBuffer.append(c);
            }
        }
        sBuffer = sBuffer.reverse();

        for(int i = 0;i< n;i++) {
            int j = i;
            while(j < n && sBuffer.charAt(j) != ' ') {
                j++;
            }
            String temp = sBuffer.substring(i, j);
            StringBuffer buffer = new StringBuffer(temp);
            temp = buffer.reverse().toString();
            sBuffer.replace(i, j , temp);
            i = j;
        }
        return sBuffer.toString();
    }

    public static String getCommonPrefix(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        int i = 0;
        while(i < len && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }
        return str1.substring(0, i);
    }
}
