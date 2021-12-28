package com.cn.algorithm.LinkedList;

/**
 * 类名:splitListToParts_725
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-22 10:15
 **/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class splitListToParts_725 {

    /**
     * 功能描述:给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
     *
     * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
     *
     * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
     *
     * 返回一个由上述 k 部分组成的数组。
    **/
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next.next = new ListNode(8);
//        head.next.next.next.next.next.next.next.next.next = new ListNode(9);
//        head.next.next.next.next.next.next.next.next.next.next = new ListNode(10);

        System.out.println(splitListToParts(head.next,3));

    }


    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode p = new ListNode(0,head);
        int length = 0;
        while (p.next != null){
            length++;
            p = p.next;
        }
        if(length <= k){
            return more(head, k);
        }
        int lest = length % k;

        ListNode[] listNodes = new ListNode[k];
        for(int i = 0; i < k; i++){
            int index = 1;
            ListNode temp = new ListNode(0);
            ListNode phead = temp;
            temp.next = new ListNode(head.val);
            int split = length / k;
            while (index < (lest == 0 ? split : split + 1)){
                temp = temp.next;
                head = head.next;
                temp.next = new ListNode(head.val);
                index++;
            }
            head = head.next;
            if(lest != 0)  lest--;
            listNodes[i] = phead.next;
        }
        return listNodes;
    }

    public static ListNode[] more(ListNode head, int k){
        ListNode[] listNodes = new ListNode[k];
        for (int i = 0; i < k; i++) {
            if(head != null){
                ListNode temp = new ListNode(head.val);
                listNodes[i] = temp;
                head = head.next;
            }else {
                listNodes[i] = new ListNode();
            }
        }
        return listNodes;
    }

}
