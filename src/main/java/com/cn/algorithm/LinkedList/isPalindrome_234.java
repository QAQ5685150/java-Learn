package com.cn.algorithm.LinkedList;

import com.cn.algorithm.dataStructure.LinkedList.ListNode;

import java.util.Stack;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.LinkedList
 * @Time: 2022-07-13 15:42
 * @Description: TODO
 **/
public class isPalindrome_234 {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        int len = getLen(head);
        Stack<ListNode> stack = new Stack<>();
        for (int i = 0; i < len / 2; i++) {
            stack.push(head);
            head = head.next;
        }
        if(len % 2 != 0) head = head.next;
        while (!stack.isEmpty()){
            ListNode pop = stack.pop();
            if(pop.val != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static int getLen(ListNode node){
        int sum = 0;
        while (node != null){
            node = node.next;
            sum++;
        }
        return sum;
    }
}
