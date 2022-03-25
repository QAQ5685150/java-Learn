package com.cn.algorithm.LinkedList;

import com.cn.algorithm.dataStructure.LinkedList.ListNode;

import java.util.List;


/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-03-25 10:47
 * @Description: �ֲ�
 * @Project_name: java-learn
 */
public class reverseList_143 {

    public static void main(String[] args) {
        ListNode node = new ListNode();
        reverse(node);
    }

    public static ListNode reverse(ListNode node){
        ListNode p = node;
        //slowһ����һ�� fastһ��������
        //������Ƕ���ͷ�ڵ㿪ʼ���ҿ��������һ����ͷ��һ����ͷ�ڵ����һ���ڵ�
        //ÿ���������һ����������Ǹտ�ʼ�Ľڵ㲻�����м�ڵ�ģ�����Ҫ����
        //�������������м�ڵ㣬��ͷ��ʼ���Ǿ���Ҫͬʱ��ͷ�ڵ�����һ����һ�� һ��������
        ListNode slow = p;
        ListNode fast = p.next;

        //�ҵ��м�ڵ� һ���������Ľڵ�Ҫ��ǰ��Ϊ���Լ���ǰ����һ���ڵ㶼��Ϊ�գ���˵�����Լ���������
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //����2 ��ת���������η�ת��һ�����м�ڵ�ǰ�ģ�һ�����м�ڵ�֮���
        //�ҵ��м�ڵ�󣬺��η�ת���������㷨�����Եݹ�Ҳ���Ե�����
        ListNode reverse = reverse(slow, slow.next);
        //���η�ת���������ٷ�תǰ�벿��
        slow.next = null;
        ListNode reverse1 = reverse(p.next, p.next.next);

        //����3 �ϲ���ת�����������
        return mergeList(reverse,reverse1);
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
        ListNode pNode = pre;
        while (pNode.next != null){
            pNode = pNode.next;
        }
        pNode.next = cur;
        return pre;
    }
}
