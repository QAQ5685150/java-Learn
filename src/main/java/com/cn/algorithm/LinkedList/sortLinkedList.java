package com.cn.algorithm.LinkedList;

import com.cn.algorithm.dataStructure.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.LinkedList
 * @Time: 2022-08-25 13:27
 * @Description: TODO
 **/
public class sortLinkedList {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,4,3,5,-1,4,-3,0,5,8);
        ListNode node = ListNode.getNode(list);
        ListNode.printList(sortInList(node));
    }

    public static ListNode sortInList (ListNode head) {
        // write code here
        ListNode root = head;
        ListNode dummy = root;
        PriorityQueue<ListNode> pq = new PriorityQueue<>( (a, b) -> {
            return a.val - b.val;
        });
        while(head.next != null){
            pq.add(head);
            head = head.next;
        }
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            root.next = node;
            root = root.next;
        }
        return dummy;
    }
}
