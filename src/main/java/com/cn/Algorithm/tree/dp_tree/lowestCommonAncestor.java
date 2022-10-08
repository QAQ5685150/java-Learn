package com.cn.Algorithm.tree.dp_tree;

import com.cn.Algorithm.dataStructure.tree.TreeNode;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.tree.dp_tree
 * @Time: 2022-10-08 10:58
 * @Description: TODO
 **/
public class lowestCommonAncestor {

    public static void main(String[] args) {


    }

    public static TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return null;
        }
        if(node == q && node == p){
            return node;
        }
        TreeNode l = lowestCommonAncestor(node.left,p,q);
        TreeNode r = lowestCommonAncestor(node.right,p,q);
        if(l != null && r != null){
            return node;
        }
        if(l != null){
            return l;
        }
        if(r != null){
            return r;
        }
        return null;
    }

    public static TreeNode lowestAncestor_dp(TreeNode head, TreeNode a, TreeNode b) {
        if (head == null) {
            return null;
        }
        return process(head, a, b).answer;
    }

    public static Info process(TreeNode x, TreeNode a, TreeNode b) {
        if (x == null) {
            return new Info(false, false, null);
        }

        // ��ȡ������������Ϣ
        Info leftInfo = process(x.left, a, b);
        Info rightInfo = process(x.right, a, b);

        // ƴ���Լ�����Ϣ
        // ��Ҫ�������Լ���a��b�����
        boolean findA = leftInfo.findA || rightInfo.findA || x == a;
        boolean findB = leftInfo.findB || rightInfo.findB || x == b;
        TreeNode answer = null;
        if (leftInfo.answer != null) {
            // �������д𰸣���˴𰸾������յĴ�
            answer = leftInfo.answer;
        } else if (rightInfo.answer != null) {
            // �������д𰸣���˴𰸾������յĴ�
            answer = rightInfo.answer;
        } else {
            // ������������û�д𰸣������ҵ���a��b����𰸾��ǵ�ǰ�ڵ�X
            if (findA && findB) {
                answer = x;
            }
        }

        return new Info(findA, findB, answer);
    }

    public static class Info{
        public boolean findA;
        public boolean findB;
        public TreeNode answer;

        public Info(boolean findA, boolean findB, TreeNode answer) {
            this.findA = findA;
            this.findB = findB;
            this.answer = answer;
        }
    }
}
