package com.cn.algorithm.algoritmBook;

import com.cn.algorithm.dataStructure.tree.TreeNode;

import java.util.Stack;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.algoritmBook
 * @Time: 2022-08-04 17:03
 * @Description: 每日错题回顾 day01
 **/
public class day08_04 {

    public static void main(String[] args) {
        TreeNode testData = TreeNode.getTestData();
        mid(testData);
    }

    /**
     * 树的非递归中序遍历
     * @param root
     */
    public static void mid(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            while (root.left != null){
                stack.push(root.left);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val + " ");
            if(root.right != null){
                root = root.right;
                stack.push(root);
            }
        }
    }



}
