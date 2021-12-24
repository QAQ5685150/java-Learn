package com.cn.algorithm;

/**
 * 类名:mergeKLists_23
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-29 14:55
 **/
public class mergeKLists_23 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(4,new ListNode(5)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode l3 = new ListNode(2,new ListNode(6));
        ListNode[] test = new ListNode[]{l1,l2,l3};
        ListNode listNode = mergeKLists(test);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        String s = "";
        for (char c : s.toCharArray()) {
            
        }
    }

    public static ListNode mergeKLists(ListNode[] lists){
        return merge(lists,0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists,int l, int r){
        if(l == r) return lists[l];
        if(l > r) return null;
        int mid =  (r + l) >> 1;
        return process(merge(lists, l, mid),merge(lists, mid + 1, r));
    }

    public static ListNode process(ListNode node1, ListNode node2){
        if(node1 == null || node2 == null){
            return node1 != null ? node1 : node2;
        }
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while (node1 != null && node2 != null){
            if(node1.val <= node2.val){
                p.next = node1;
                p = p.next;
                node1 = node1.next;
            }else {
                p.next = node2;
                p = p.next;
                node2 = node2.next;
            }
        }
        if(node1 != null){
            p.next = node1;
        }
        if(node2 != null){
            p.next = node2;
        }
        return dummy.next;
    }
}
