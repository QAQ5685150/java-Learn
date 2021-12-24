package com.cn.algorithm.structure;

import jdk.nashorn.internal.objects.annotations.Constructor;

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

//    @Override
//    public String toString() {
//        if(this == null){
//            return "null";
//        }
//
//        String data = String.valueOf(val) + " ";
//        String left = this.left.toString();
//        String right = this.right.toString();
//
//        return "TreeNode{" +
//                "val=" + val +
//                ", left=" + left +
//                ", right=" + right +
//                '}';
//    }
}




