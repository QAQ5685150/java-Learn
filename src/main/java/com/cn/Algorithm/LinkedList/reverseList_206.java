package com.cn.Algorithm.LinkedList;

import com.cn.Algorithm.dataStructure.LinkedList.ListNode;

/**
 * 类名: reverseList_206
 * 描述: TODO
 * 姓名: @author南风
 * 日期: 2022-02-17 14:15
 **/
public class reverseList_206 {

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(1);
        ListNode processed = reverseList(node);
        ListNode.printList(processed);
        System.out.println();

        ListNode node1 = new ListNode(5);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(2);
        node1.next.next.next.next = new ListNode(1);
        ListNode node2 = reverseList1(node1);
        ListNode.printList(node2);
    }
    /**
    *功能描述:迭代法 反转链表
    *@param node
    *@return ListNode
    **/
    // pre -> cur -> next -> next1
    // pre <- cur <- next <- next1
    public static ListNode reverseList1(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
    *功能描述:反转链表  递归法： 接收两个指针，一个pre 一个cur，递归内新建下一个指针next，指向cur的next
     *  递归内 让cur指向pre 然后递归往下执行
    *@param node
    *@return ListNode
    **/
    public static ListNode reverseList(ListNode node){
        return reverseList(null,node);
    }

    public static ListNode reverseList(ListNode cur,ListNode tmp) {
        if(tmp == null){
            return cur;
        }
        ListNode next = tmp.next;
        tmp.next = cur;
        return reverseList(tmp,next);
    }
}
