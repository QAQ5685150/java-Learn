package com.cn.Algorithm.LinkedList;

import com.cn.Algorithm.dataStructure.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.LinkedList
 * @Time: 2022-08-15 10:19
 * @Description: TODO
 **/
public class reverseKGroup_25 {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 1, 2, 3, 4, 5, 6, 7, 8);

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        Collections.addAll(arrayList1, 1, 2, 3, 4, 5, 6, 7, 8);

        ListNode node = ListNode.getNode(arrayList);
        ListNode p = node;
        ListNode p1 = ListNode.getNode(arrayList1);
        ListNode.printList(node);
        System.out.println();

        ListNode res = reverseKGroup(node, 3);
        ListNode.printList(res);
        System.out.println();

        ListNode listNode = reverseKGroup1(p, 4);
        ListNode.printList(listNode);
        System.out.println();

        ListNode listNode1 = reverseKGroup2(p1,4);
        ListNode.printList(listNode1);
        System.out.println();
    }

    /**
     * 栈的方式k个一组反转链表
     *
     * @param node
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode node, int k) {
        if (k < 2) return node;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        ListNode root = new ListNode();
        ListNode pNode = root;
        ListNode p = node;
        while (p != null) {
            p = p.next;
            index++;
        }
        System.out.println(index);
        while (node != null) {
            if (index < k) {
                while (node != null) {
                    root.next = new ListNode(node.val);
                    node = node.next;
                    root = root.next;
                }
            }
            for (int i = 0; i < k && node != null; i++) {
                stack.push(node.val);
                node = node.next;
                index--;
            }
            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                root.next = new ListNode(pop);
                root = root.next;
            }
        }
        return pNode.next;
    }

    public static ListNode reverseKGroup1(ListNode node, int k) {
        if (k < 2) return node;
        ListNode pNode = new ListNode();
        pNode.next = node;
        ListNode pre = pNode;
        while (true) {
            ListNode p = pre;
            for (int i = 0; i < k; i++) {
                p = p.next;
                if (p == null) {
                    return pNode.next;
                }
            }
            ListNode cur = pre.next, next;
            for (int i = 0; i < k - 1; i++) {
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = cur;
        }
    }
//1 2 3 4 5 6
    public static ListNode reverseKGroup2(ListNode node, int k){
        ListNode tail = node;
        for (int i = 0; i < k; i++) {
            if(tail == null){
                return node;
            }
            tail = tail.next;
        }
        ListNode pre = null;
        ListNode cur = node;
        while (cur != tail){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        node.next = reverseKGroup2(tail, k);
        return pre;
    }
}