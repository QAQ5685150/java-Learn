package com.cn.algorithm.LinkedList;

import com.cn.algorithm.dataStructure.LinkedList.ListNode;

import java.util.*;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-04-23 14:02
 * @Description: TODO
 * @Project_name: java-learn
 */
public class deleteDuplicates_nc24 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,3,4,4,5);
        ListNode node = deleteDuplicates(ListNode.getNode(list));
        ListNode.printNode(node);
    }

    public static ListNode deleteDuplicates_hash(ListNode head) {
        // write code here
        ListNode p = new ListNode(0);

        p.next = head;
        ListNode phead = new ListNode(0);
        ListNode ans = phead;
        HashMap<Integer,Integer> map = new HashMap<>();
        while (head != null){
            map.put(head.val, map.getOrDefault(head.val,0) + 1);
            head = head.next;
        }

        while(p.next != null){
            if(map.get(p.next.val) <= 1){
                phead.next = new ListNode(p.next.val);
                p = p.next;
                phead = phead.next;
            }else {
                p = p.next;
            }
        }
        return ans.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ans = dummy;

        while (dummy.next != null && dummy.next.next != null){
            if(dummy.next.val == dummy.next.next.val){
                int cur = dummy.next.val;
                while (dummy.next != null && dummy.next.val == cur){
                    dummy.next = dummy.next.next;
                }
            }else {
                dummy = dummy.next;
            }
        }
        return ans.next;
    }
}
