package com.cn.Algorithm.LinkedList;

import com.cn.Algorithm.dataStructure.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类名:mergeKLists_23
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-29 14:55
 **/
public class mergeKLists_23 {

    /**
     * 功能描述:给你一个链表数组，每个链表都已经按升序排列。
     *
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     **/
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        ListNode[] test = new ListNode[]{l1, l2, l3};
        ListNode listNode = mergeKLists(test);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        String s = "";
        for (char c : s.toCharArray()) {
        }
    }

    /**
     * 功能描述:归并算法合并链表
     * @param lists
     * @return com.cn.algorithm.dataStructure.LinkedList.ListNode
     **/
    public static ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        if (l > r) return null;
        int mid = (r + l) >> 1;
        return process(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public static ListNode process(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return node1 != null ? node1 : node2;
        }
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                p.next = node1;
                p = p.next;
                node1 = node1.next;
            } else {
                p.next = node2;
                p = p.next;
                node2 = node2.next;
            }
        }
        if (node1 != null) {
            p.next = node1;
        }
        if (node2 != null) {
            p.next = node2;
        }
        return dummy.next;
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        int len = lists.size() - 1;
        return process(lists,0,len);
    }

    public ListNode process(ArrayList<ListNode> lists, int i, int j){
        //这块的返回逻辑和merge sort不一样，mergesort函数是void函数，i>l就返回了
        //这里要从ArrayList<ListNode> 里面取数据，
        if(i > j) return null;
        if(i == j) return lists.get(i);
        int mid = ((j + i) >> 1);
        return mergeList(process(lists,i,mid),process(lists,mid + 1,j));
    }

    public ListNode mergeList(ListNode node1,ListNode node2){
        if(node1 == null || node2 == null){
            return node1 == null ? node2 : node1;
        }
        ListNode dd = new ListNode(-1);
        ListNode dummy = dd;
        while(node1 != null && node2 != null){
            if(node1.val < node2.val){
                dummy.next = node1;
                node1 = node1.next;
            }else{
                dummy.next = node2;
                node2 = node2.next;
            }
            dummy = dummy.next;
        }
        if(node1 != null){
            dummy.next = node1;
        }
        if(node2 != null){
            dummy.next = node2;
        }
        return dd.next;
    }
}


class test{

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 2, 5, 7, 4, 6, 1, 8, 9);
        for (Integer integer : merge(list)) {
            System.out.print(integer + " ");
        }
    }

    public static List<Integer> merge(List<Integer> list){

        return merge(list,0,list.size());
    }

    public static List<Integer> merge(List<Integer> list, int l, int r){
        if(l == r) return list;
        int mid = (l + r) >> 1;
        return process(merge(list.subList(l,mid), l, mid),merge(list,mid + 1, r));
    }

    public static List<Integer> process(List<Integer> l1, List<Integer> l2){
        List<Integer> arr = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 <= l1.size() && index2 <= l2.size()){
            Integer i1 = l1.get(index1);
            Integer i2 = l2.get(index2);
            if(i1 <= i2){
                arr.add(i1);
                index1++;
            }else {
                arr.add(i2);
                index2++;
            }
        }
        if(index1 != l1.size() - 1){
            for (int i = index1; i < l1.size(); i++) {
                arr.add(l1.get(i));
            }
        }
        if(index2 != l2.size() - 1){
            for (int i = index2; i < l2.size(); i++) {
                arr.add(l2.get(i));
            }
        }
        return arr;
    }
}