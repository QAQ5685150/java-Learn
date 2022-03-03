package com.cn.algorithm.LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-03-03 18:24
 * @Description: 复杂链表的复制 剑指offer 35
 * @Project_name: java-learn
 */
public class copyRandomList {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node pNode = head;
        while(pNode != null){
            Node node = new Node(pNode.val);
            map.put(pNode,node);
            pNode = pNode.next;
        }
        Node p = head;
        while(p != null){
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {

    }
}
