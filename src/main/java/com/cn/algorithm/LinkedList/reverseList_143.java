package com.cn.algorithm.LinkedList;

import com.cn.algorithm.dataStructure.LinkedList.ListNode;

import java.util.List;


/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-03-25 10:47
 * @Description: 局部
 * @Project_name: java-learn
 */
public class reverseList_143 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode.printList(reverse(node));
    }

    public static ListNode reverse(ListNode node){
        ListNode p = node;
        //slow一次走一步 fast一次走两步
        //我理解是都从头节点开始，我看的题解是一个从头，一个从头节点的下一个节点
        //每道题情况不一样，这道题是刚开始的节点不算做中间节点的，所以要这样
        //如果是找链表的中间节点，从头开始，那就需要同时从头节点往下一个走一步 一个走两步
        ListNode slow = p;
        ListNode fast = p.next;

        //找到中间节点 一次走两步的节点要当前不为空以及当前的下一个节点都不为空，才说明可以继续往下走
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //步骤2 反转链表，分两段反转，一段是中间节点前的，一段是中间节点之后的
        //找到中间节点后，后半段反转链表（经典算法，可以递归也可以迭代）
        ListNode reverse = reverse(null, slow.next);
        //后半段反转完后锻炼，再反转前半部分
        slow.next = null;

        //步骤3 合并反转后的两个链表
        //理解错了，我以为两个都反正以后挂在后面就行了，其实是反转后一部分，前面的不懂，交错形成一个新链表挂在head后面
        p.next = mergeList(reverse,node.next);
        return p;
    }

    public static ListNode reverse(ListNode pre,ListNode cur){
        if(cur == null){
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur,next);
    }

    public static ListNode mergeList(ListNode pre,ListNode cur){
        ListNode pNode = new ListNode();
        ListNode p = pNode;
        int index  = 0;
        while (pre != null || cur != null){
            if(index % 2 == 0){
                pNode.next = pre;
                pNode = pNode.next;
                pre = pre.next;
                index++;
            }else {
                pNode.next = cur;
                pNode = pNode.next;
                cur = cur.next;
                index++;
            }
        }
        if(pre != null){
            pNode.next = pre;
        }
        return p.next;
    }
}
