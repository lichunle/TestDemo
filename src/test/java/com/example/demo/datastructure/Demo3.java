package com.example.demo.datastructure;

import java.util.Stack;

public class Demo3 {



    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);

        ListNode node2 = new ListNode(2);

        ListNode node3 = new ListNode(3);

        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        revert(node1);

    }

    public static ListNode revert(ListNode node) {

        Stack<ListNode> stack = new Stack<>();

        while(node != null) {
            stack.push(node);
            node = node.next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        ListNode node1 = stack.pop();
        ListNode resNode = node1;
        while(!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            node1.next = tempNode;
            node1 = node1.next;
        }
        node1.next = null;

        return resNode;
    }
}



