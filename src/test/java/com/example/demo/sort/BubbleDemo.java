package com.example.demo.sort;

import java.util.Arrays;

public class BubbleDemo {

    public static void main(String[] args) {
        int[] arr = {5,4,1,8,3,7};

        System.out.println(Arrays.toString(bubble2(arr)));
    }
    public static int[] sort(int[] array) {

        int len = array.length;

        for (int i = 1; i < len; i++) {

            for (int j = 0; j < len-i; j++) {

                if(array[j] > array[j+1]) {
                    int tempNum = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tempNum;
                }

            }
        }
        return array;
    }


//    public static int[] bubbule(int[] arr) {
//
//        int len = arr.length;
//
//        for (int i = 1; i < len; i++) {
//
//            for (int j = 0; j < len-1; j++) {
//
//                if(arr[j] > arr[j + 1]) {
//                    int tempNum = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = tempNum;
//                }
//            }
//        }
//        return arr;
//    }


    public static int[] bubble2(int[] arr) {

        for(int i = 1;i < arr.length;i++) {

            for(int j = 0;j< arr.length-1;j++) {

                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
