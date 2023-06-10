package com.example.demo.search;

public class OrderSearch {

    public static void main(String[] args) {
        int[] arr = {5,4,1,8,3,7};
        System.out.println(order(arr, 3));
    }

    public static int order(int[] arr, int target) {

        for(int i = 0;i <arr.length;i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
