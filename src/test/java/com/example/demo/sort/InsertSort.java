package com.example.demo.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {5,4,1,8,3,7};


        try {
            InsertSort insertSort = InsertSort.class.newInstance();
            System.out.println(Arrays.toString(insertSort.insertSort(arr)));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


    public int[] insertSort(int[] arr) {

        int len = arr.length;

        for(int i = 1; i< len;i++) {
            // 要插入最小值
            int temp = arr[i];
            // 从已经排序好的最右侧开始查找
            int j = i;
            while(j > 0 && temp < arr[j-1]) {
                arr[j] = arr[j-1];
                j--;
            }
            if (i != j) {
                arr[j] = temp;
            }
        }
        return arr;
    }
}
