package com.cn.Algorithm.LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-03-03 18:24
 * @Description: ��������ĸ��� ��ָoffer 35
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

    //����������review
    //�����е㲻����37�У��ⲻ���ǰ�head������װ��һ��ô��
    //Ϊɶ˵�Ǹ����أ�û�㶮��
    //��������ѧ���ˣ���mapװnode�ڵ㣬�ٶԽڵ�ȡ������
    //�е�����map��class�� �ó�����������������
    //�����ǽ���Ϣע�� ��ѯ�����Ǹ�ģʽ
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
