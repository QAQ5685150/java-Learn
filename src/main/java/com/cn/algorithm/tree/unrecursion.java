package com.cn.algorithm.tree;

import com.cn.algorithm.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 类名:pro_unrecursion
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-28 13:44
 **/
public class unrecursion {

    public static void main(String[] args) {
        TreeNode test = TreeNode.getTestData();
        pro(test);
        System.out.println();
        mid(test);
        System.out.println();


        TreeNode node = TreeNode.insertData("");
        pro(node);
    }

    public static List<Integer> pro(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(treeNode);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            System.out.print(pop.val + " ");
            list.add(pop.val);
            if (pop.right != null){
                stack.push(pop.right);
            }
            if(pop.left != null){
                stack.push(pop.left);
            }
        }
        return list;
    }

    public static void mid(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode dummy = treeNode; //哑节点操作treeNode 保证root指针位置不变
        while (dummy != null || !stack.isEmpty()){
            while (dummy != null){
                stack.push(dummy);
                dummy = dummy.left;
            }
            if(!stack.isEmpty()){
                dummy = stack.pop();
                System.out.print(dummy.val + " ");
                dummy = dummy.right;
            }
//            dummy = stack.pop();
//            System.out.print(dummy.val + " ");
//            if(dummy.right != null){
//                dummy = dummy.right;
//            }else {
//                dummy = null;
//            }
        }
    }

    public static void back(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = treeNode;
        while (!stack.isEmpty()){

        }

    }

}
