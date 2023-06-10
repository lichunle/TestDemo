package com.example.demo.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Demo0523 {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode treeNode) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (null == treeNode) {
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);

        while(!queue.isEmpty()) {
            ArrayList<Integer> row = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode tNode = queue.poll();
                row.add(tNode.val);
                if(tNode.left != null) {
                    queue.add(tNode.left);
                }
                if(tNode.right != null) {
                    queue.add(tNode.right);
                }
            }
            list.add(row);
        }
        return list;
    }

    public static void main(String[] args) {
//        Scanner c = new Scanner(System.in);
//
//        while(c.hasNextLine()) {
//            String str = c.nextLine();
//            System.out.println(str);
//
//        }
        int a = 81;
        System.out.println(changeButtol(a));
//        System.out.println(Integer.toHexString(a));
    }

    public static int changeButtol(int nums) {


        int count = 0;
        while (true) {
            int a = nums / 3;
            int b = nums % 3;
            int m = a + b;
            count += a;
            if (m < 3) {
                if (m == 2) {
                    count = count +1;
                }
                break;
            } else {
                nums = m;
            }
        }
        return count;
    }
}

class TreeNode {
   int val = 0;
   TreeNode left = null;
   TreeNode right = null;
}
