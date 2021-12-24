package com.cn.algorithm;

import java.util.*;
import java.util.concurrent.ExecutorService;

import com.cn.algorithm.structure.ListNode;

/**
 * 类名:nextLargerNodes_1019
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-15 16:51
 **/
public class nextLargerNodes_1019 {

    public static void main(String[] args) {
        ListNode pNode = new ListNode(1);
        pNode.next = new ListNode(7);
        pNode.next.next = new ListNode(5);
        pNode.next.next.next = new ListNode(1);
        pNode.next.next.next.next = new ListNode(9);
        pNode.next.next.next.next.next = new ListNode(2);
        pNode.next.next.next.next.next.next = new ListNode(5);
        pNode.next.next.next.next.next.next.next = new ListNode(1);
        ListNode.printList(pNode);
    }

    public static int[] nextLargerNodes(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        Stack<ListNode> stack = new Stack<>();
        List<Integer> arrayList = new ArrayList<>();
        while (dummy.next != null){
            while (!stack.isEmpty() && dummy.val < stack.peek().val){
                stack.push(dummy);
                dummy = dummy.next;
            }
            ListNode pop = stack.pop();
            arrayList.add(pop.val);
            dummy = dummy.next;
        }

        int[] ans = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            ans[i] = arrayList.get(i);
        }
        return ans;
    }
}
