package com.example.demo.bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo1 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        String[] secret1 = sc.nextLine().split(",");
        String[] secretShow = sc.nextLine().split(",");

        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < secret1.length; i++) {
            String tempSec = secret1[i];

            boolean isHit = false;
            for (int j = 0; j < secretShow.length; j++) {
                String secShow = secretShow[j];
                if (exchangeCheck(tempSec, secShow)) {
                    resultList.add(secShow);
                    isHit = true;
                } else if (chongfuCheck(tempSec, secShow)) {
                    resultList.add(secShow);
                    isHit = true;
                }
            }
            if (!isHit) {
                resultList.add("not found");
            }
        }
        StringBuilder sBuffer = new StringBuilder("");
        for(int i = 0;i < resultList.size();i++) {
            sBuffer.append(resultList.get(i)).append(",");
        }
        System.out.println(sBuffer.toString().substring(0, sBuffer.length()-1));
    }

    static boolean exchangeCheck(String str1, String str2) {
        boolean result = false;
        char[] c1 = str1.toCharArray();
        Arrays.sort(c1);
        char[] c2 = str2.toCharArray();
        Arrays.sort(c2);
        if (Arrays.equals(c1, c2)) {
            result = true;
        }
        return result;
    }

    static boolean chongfuCheck(String str1, String str2) {
        boolean result = false;
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        List<Character> list1 = new ArrayList<>();

        for (int i = 0; i < c1.length; i++) {
            if (list1.contains(c1[i])) {
                continue;
            }
            list1.add(c1[i]);
        }

        List<Character> list2 = new ArrayList<>();

        for (int i = 0; i < c2.length; i++) {
            if (list2.contains(c2[i])) {
                continue;
            }
            list2.add(c2[i]);
        }

        if (list1.equals(list2)) {
            result = true;
        }
        return result;
    }
}
