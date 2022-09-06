package com.cn.Algorithm.algoritmBook.daily.august;

import com.cn.Algorithm.dataStructure.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.algoritmBook
 * @Time: 2022-08-15 9:55
 * @Description: 反转链表两种方法、跳跃游戏、k个一组反转链表
 **/
public class day08_15 {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 1, 2, 3, 4, 5, 6, 7, 8);

        ListNode node = ListNode.getNode(arrayList);
        ListNode.printList(node);
        System.out.println();

        ListNode reverseNode = reverseNodeRecursion(node);
        ListNode.printList(reverseNode);
        System.out.println();

        ListNode reverseNodeUnRecursion = reverseNodeUnRecursion(reverseNode);
        ListNode.printList(reverseNodeUnRecursion);
        System.out.println();

    }

    //递归反转链表
    public static ListNode reverseNodeRecursion(ListNode node) {
        return reverse(null, node);
    }

    public static ListNode reverse(ListNode cur, ListNode tmp) {
        if (tmp == null) {
            return cur;
        }
        ListNode next = tmp.next;
        tmp.next = cur;
        cur = tmp;
        return reverse(cur, next);
    }

    //非递归反转链表
    public static ListNode reverseNodeUnRecursion(ListNode node) {
        ListNode p = null;
        ListNode tmp = node;
        while (tmp != null) {
            ListNode next = tmp.next;
            tmp.next = p;
            p = tmp;
            tmp = next;
        }
        return p;
    }

    public static boolean canJump(int[] arr){
        int len = arr.length;
        int right = 0;
        for (int i = 0; i < len; i++) {
            if(i <= right){
                right = Math.max(i + arr[i], right);
                if(right > len - 1) return true;
            }
        }
        return false;
    }
}
