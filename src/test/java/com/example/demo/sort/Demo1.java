package com.example.demo.sort;

public class Demo1 {

    public int[] MySort (int[] arr) {
        // write code here
        for(int i=0; i< arr.length;i++) {

            for (int j = i+1; j < arr.length; j++) {

            }
        }
        return arr;
    }


    public int orderSort(int[] arr, int n, int key) {

        for (int i = 0; i < n; i++) {
            if(key == arr[i]) {
                return i;
            }
        }
        return 0;
    }

}
