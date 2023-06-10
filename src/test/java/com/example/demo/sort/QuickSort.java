package com.example.demo.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5,4,1,8,3,7};
        int[] array = quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(array));
    }


    public static int[] quickSort(int[] arr, int left, int right) {

        if (left < right) {
            int pai = pai(arr, left, arr.length-1);
            quickSort(arr, left, pai-1);
            quickSort(arr, pai+1, right);
        }
        return arr;
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot +1;

        for(int i = index;i <= right;i++) {

            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot,index-1);
        return index-1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int pai(int[] arr, int left, int right) {

        int priv = left;
        int index = priv + 1;

        for(int i = index; i<= right;i++) {

            if (arr[i] < arr[priv]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, priv, index-1);

        return index-1;
    }
}
