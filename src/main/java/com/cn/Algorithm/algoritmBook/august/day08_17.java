package com.cn.Algorithm.algoritmBook.august;

import com.cn.Algorithm.dataStructure.LinkedList.ListNode;

import java.util.*;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.algoritmBook
 * @Time: 2022-08-17 11:02
 * @Description: tags : counter hash linkedList
 **/
public class day08_17 {

    public static void main(String[] args) {
        int[] test = new int[]{2,2,3,3,2,4,4,4,4,4};
        System.out.println(minimumRounds_2244(test));

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        List<Integer> l4 = new ArrayList<>();
        Collections.addAll(l1,1,3,4,6,7);
        Collections.addAll(l2,2,5,7,8,9);
        Collections.addAll(l3,3,4,9,16,17);
        Collections.addAll(l4,1,3,14,16,27);
        ListNode node1 = ListNode.getNode(l1);
        ListNode node2 = ListNode.getNode(l2);
        ListNode node3 = ListNode.getNode(l3);
        ListNode node4 = ListNode.getNode(l4);
        ListNode[] testNode = new ListNode[]{node1,node2,node3,node4};
        ListNode listNode = mergeKLists(testNode);
        ListNode.printList(listNode);
    }

    /**
     * 299. 猜数字游戏
     * 字符串、counter计数、hash
     * @param secret
     * @param guess
     * @return
     */
    public static String getHint_299(String secret, String guess){
        int a = 0;
        int b = 0;
        int[] countS = new int[10];
        int[] countG = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int c1 = secret.charAt(i) - '0';
            int c2 = guess.charAt(i) - '0';
            if(c1 == c2) {
                a++;
            }else {
                countS[c1]++;
                countG[c2]++;
            }
        }
        for (int i = 0; i < countG.length; i++) {
            b += Math.min(countS[i],countG[i]);
        }
        return a + "A" + b + "B";
    }

    /**
     * 554. 砖墙
     * hashMap、counter计数
     * @return
     */
    public static int leastBricks_554(List<List<Integer>> wall){
        int high = wall.size();
        HashMap<Integer,Integer> cntMap = new HashMap<>();
        for (List<Integer> list : wall) {
            int start = 0;
            for (int i = 0; i < list.size(); i++) {
                start += list.get(i);
                if(i != list.size() - 1) cntMap.put(start,cntMap.getOrDefault(start,0) + 1);
            }
        }
        //对于[[1],[1],[1]]这样的数据，res=高度，如果没有墙缝，就是最大高度
        int res = high;
        Iterator<Map.Entry<Integer, Integer>> iterator = cntMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            res = Math.min(res,high - next.getValue());
        }
        return res;
    }

    /**
     * 2244. 完成所有任务需要的最少轮数
     * @param tasks
     * @return
     */
    public static int minimumRounds_2244(int[] tasks) {
        int len = tasks.length;
        HashMap<Integer,Integer> cntMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            cntMap.put(tasks[i],cntMap.getOrDefault(tasks[i],0) + 1);
        }
        int res = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = cntMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer value = next.getValue();
            if (value == 1) {
                return -1;
            }
            res += value % 3 == 0 ? value / 3 : (value / 3) + 1;
        }
        return res;
    }


    /**
     * 23. 合并K个升序链表
     * 堆（优先队列）、链表 、归并
     * @param lists
     * @return
     */
    public static ListNode mergeKLists_priorityQueue(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode list : lists) {
            while (list != null){
                pq.add(list.val);
                list = list.next;
            }
        }
        ListNode root = new ListNode();
        ListNode dummy = root;
        while (!pq.isEmpty()){
            root.next = new ListNode(pq.poll());
            root = root.next;
        }
        return dummy.next;
    }

    public static ListNode mergeKLists(ListNode[] lists){
        return mergeKLists(lists,0,lists.length - 1);
    }

    public static ListNode mergeKLists(ListNode[] lists,int l,int r){
        if(l >= r) return lists[l];
        int mid = (l + r) / 2;
        return merge(mergeKLists(lists,l,mid),mergeKLists(lists,mid + 1,r));
    }

    public static ListNode merge(ListNode left, ListNode right){
        ListNode root = new ListNode();
        ListNode dummy = root;
        while (left != null && right != null){
            if(left != null && left.val < right.val){
                root.next = new ListNode(left.val);
                left = left.next;
            }
            if(right != null && right.val < left.val){
                root.next = new ListNode(right.val);
                right = right.next;
            }
        }
        if (left.next != null){
            root.next = left.next;
        }
        if (right.next != null){
            root.next = right.next;
        }
        return dummy.next;
    }
}
