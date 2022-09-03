package com.cn.Algorithm.array.stack;

import java.util.*;

import com.cn.Algorithm.dataStructure.LinkedList.ListNode;

/**
 * 类名:nextLargerNodes_1019
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-15 16:51
 **/
public class nextLargerNodes_1019 {

    /**
     * 给出一个以头节点head作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
     *
     * 每个节点都可能有下一个更大值（next larger value）：对于node_i，如果其next_larger(node_i)是node_j.val，那么就有j > i且node_j.val > node_i.val，而j是可能的选项中最小的那个。如果不存在这样的j，那么下一个更大值为0。
     *
     * 返回整数答案数组answer，其中answer[i] = next_larger(node_{i+1})。
     *
     * 例：
     * 输入：[2,1,5]
     * 输出：[5,5,0]
    **/
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
        System.out.println();
        int[] ints = nextLargerNodes1(pNode);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    /**
    *功能描述:没想出来
    **/
    public static int[] nextLargerNodes(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        Stack<ListNode> stack = new Stack<>();
        List<Integer> arrayList = new ArrayList<>();
        while (dummy.next != null){
            while (!stack.isEmpty() && dummy.val < stack.peek().val){
                stack.push(dummy);
                dummy = dummy.next;
            }
            stack.push(dummy);
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

    /**
    *功能描述:单调栈版本
     * 从右往左遍历，如果栈里没有值，说明没有比当前更大的，置为0，否则置为栈顶元素，弹出栈顶
    *@param head
    *@return int[]
    **/
    public static int[] nextLargerNodes1(ListNode head) {
        if (head == null) {
            return null;
        }
        // 1. 创建一个容器 list 来存储数据
        ArrayList<Integer> list = new ArrayList<>();
        int size = 0;
        while (head != null) {
            list.add(head.val);
            size++;
            head = head.next;
        }
        // 2. 创建一个栈 stack ，这个栈里面存储的是对应位置的 list 元素及其之后元素中最大的值。
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[size];
        // 3. 在 list 中从右往左遍历，stack 中凡是比 list.get(i) 小的都 pop 出去，
        // 这样 stack 剩下的元素都是比 list.get(i) 更大的元素。
        for (int i = list.size() - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= list.get(i)) {
                stack.pop();
            }
            ans[i] = stack.empty() ? 0 : stack.peek();
            stack.push(list.get(i));
        }
        return ans;
    }
}
