package com.cn.algorithm.LinkedList;

import com.cn.algorithm.dataStructure.LinkedList.ListNode;

/**
 * 类名: listTestData
 * 描述: 单例模式搞一个生成listNode
 * 姓名: @author南风
 * 日期: 2021-12-30 10:54
 **/
public class listTestData {

    private volatile static ListNode listNode;

    /**
     * 功能描述:双重检查单例模式 双重检查意思是在synchronized前后各检查一次要创建的对象是否为空，否则多线程情况下可能出现
     * 创建两次的情况 如果一个线程过了第一个检查，卡在syn 第二个创建好出去，卡在syn的进去没有判空，又创建了一次
     * @return com.cn.algorithm.LinkedList.ListNode
     **/
    public static ListNode newInstance() {
        if (listNode == null) {
            synchronized (listTestData.class) {
                if (listNode == null) {
                    listNode = new ListNode();
                }
            }
        }
        return listNode;
    }

    /**
     * 功能描述:获取测试数据
     * @return com.cn.algorithm.dataStructure.LinkedList.ListNode
     **/
    public ListNode getTestData() {
        ListNode head = this.newInstance();
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next.next = new ListNode(7);
        return head;
    }

}
