package com.cn.Algorithm.dataStructure.LinkedList;

import java.util.List;

/**
 * 类名:ListNode
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-15 16:50
 **/
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printList(ListNode pNode) {
        while (pNode != null) {
            if (pNode.next != null) {
                System.out.print(pNode.val + " -> ");
            } else {
                System.out.print(pNode.val);
            }
            pNode = pNode.next;
        }

    }

    public static ListNode getNode(List<Integer> list) {
        ListNode node = new ListNode(0);
        ListNode p = node;
        for (Integer integer : list) {
            node.next = new ListNode(integer);
            node = node.next;
        }
        return p.next;
    }

    public static void printNode(ListNode pNode){
        while (pNode != null){
            if(pNode.next == null){
                System.out.print(pNode.val);
                break;
            }
            System.out.print(pNode.val + " -> ");
            pNode = pNode.next;
        }
    }
}
