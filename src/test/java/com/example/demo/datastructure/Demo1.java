package com.example.demo.datastructure;

import java.util.Stack;

public class Demo1 {

    public static void main(String[] args) {


        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;



        ListNode resultNode = Merge(node1, node1);
    }

    public static ListNode Merge(ListNode list1,ListNode list2) {

        ListNode node = new ListNode(-1);
        ListNode resultNode = node;
        while(list1 != null && list2 != null) {
            int num1 = list1.val;
            int num2 = list2.val;
            ListNode tempNode = null;
            if(num1 < num2) {
                tempNode = new ListNode(num1);
                list1 = list1.next;
            } else {
                tempNode = new ListNode(num2);
                list2 = list2.next;
            }
            node.next = tempNode;
            node = node.next;
        }
        if (list1 != null) {
            node.next = list1;
        }
        if (list2 != null) {
            node.next = list2;
        }
        return resultNode.next;
    }

    public static ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while(head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        ListNode node = stack.pop();
        ListNode resultNode = node;
        while(!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        node.next = null;
        return resultNode;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}