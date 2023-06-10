package com.example.demo.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {5,4,1,8,3,7};

        System.out.println(Arrays.toString(select(arr)));
    }

    public static int[] select(int[] arr) {

        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            int min = i;

            for(int j = i+1;j < len;j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }
}
