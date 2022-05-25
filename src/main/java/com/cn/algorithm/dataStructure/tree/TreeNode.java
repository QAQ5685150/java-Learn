package com.cn.algorithm.dataStructure.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 类名:TreeNode
 * 描述:树型数据结构
 * 姓名:南风
 * 日期:2021-09-28 11:42
 **/
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
    *功能描述:获取测试用例
    *@return TreeNode
    **/
    public static TreeNode getTestData(){
        return new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)),
                        new TreeNode(0, new TreeNode(), new TreeNode())),
                new TreeNode(8, new TreeNode(13, new TreeNode(5), new TreeNode(1)),
                        new TreeNode(4)));
    }

    /**
    *功能描述:
    *@param data
    *@return TreeNode
    **/
    public static TreeNode insertData(String data){
        String[] split = data.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String i : split) {
            queue.add(i);
        }
        return helper(queue);
    }

    private static TreeNode helper(Queue<String> queue){
        String poll = queue.poll();
        if("#".equals(poll)){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(poll));
        node.left = helper(queue);
        node.right = helper(queue);
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.insertData("21!7!1!3!#!#!3!#!#!1!#!#!14!2!#!#!2!#!#!");
        System.out.println(node);
    }

    @Override
    public String toString() {
        if(this == null){
            return null;
        }
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left.toString() +
                ", right=" + right.toString() +
                '}';
    }
}




