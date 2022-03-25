package com.cn.algorithm.LinkedList;

import org.w3c.dom.Node;

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

    //复杂链表复制review
    //还是有点不明白37行，这不就是把head给重新装配一遍么？
    //为啥说是复制呢？没搞懂啊
    //不过还是学到了，用map装node节点，再对节点取出操作
    //有点类似map放class类 拿出来便利掉方法那种
    //好像是叫消息注册 轮询发布那个模式
    public static Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node pNode = head;
        while (pNode != null){
            Node node = new Node(pNode.val);
            map.put(pNode,node);
        }
        Node p = head;
        while (p.next != null){
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {

    }
}
