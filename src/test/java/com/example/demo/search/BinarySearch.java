package com.example.demo.search;

public class BinarySearch {


    public static void main(String[] args) {
        int[] arr = {1,2,3,5,7,10};

        System.out.println(binary1(arr, 5, 0, arr.length-1));
    }


    public static int binary(int[] arr, int target, int left, int right) {

        int mid = (left + right) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binary(arr, target, left, mid-1);
        } else if(arr[mid] < target) {
            return binary(arr, target, mid+1, right);
        }
        return -1;
    }


    public static  int binary1(int[] arr, int target, int left, int right) {

        int mid = (left+right) /2;
        if(arr[mid] == target) {
            return mid;
        } else if(arr[mid] < target) {
            return binary1(arr, target, mid +1, right);
        } else if(arr[mid] > target) {
            return binary1(arr, target, left, mid-1);
        }
        return -1;
    }
}
