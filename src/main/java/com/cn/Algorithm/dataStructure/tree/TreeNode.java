package com.cn.Algorithm.dataStructure.tree;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 类名:TreeNode
 * 描述:树型数据结构
 * 姓名:南风
 * 日期:2021-09-28 11:42
 **/
public class TreeNode implements Serializable {

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
                new TreeNode(5, new TreeNode(5, new TreeNode(7), new TreeNode(2)),
                        new TreeNode(0, new TreeNode(), new TreeNode())),
                new TreeNode(8, new TreeNode(13, new TreeNode(5), new TreeNode(1)),
                        new TreeNode(4)));
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.getTestData();
        String serialize = node.serialize(node);
        System.out.println(serialize);
        TreeNode deserialize = node.deserialize(serialize);
        System.out.println(node.toStringHelper(deserialize));
    }

    //treeNode toString override
    @Override
    public String toString() {
        return toStringHelper(this);
    }

    private String toStringHelper(TreeNode root){
        if (root == null){
            return "null";
        }
        return "TreeNode{" +
                "val=" + val +
                ", left=" + toStringHelper(root.left) +
                ", right=" + toStringHelper(root.right) +
                '}';
    }

    public String serialize(TreeNode root){
        if(root == null){
            return "#!";
        }
        String val = new String(root.val + "!");
        val += serialize(root.left);
        val += serialize(root.right);
        return val;
    }

    public TreeNode deserialize(String sequence){
        String[] split = sequence.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String s : split) {
            queue.add(s);
        }
        return deserializeHelper(queue);
    }

    public TreeNode deserializeHelper(Queue<String> queue){
        String poll = queue.poll();
        if ("#".equals(poll)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(poll));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);
        return root;
    }


}




