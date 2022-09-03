package com.cn.Algorithm.tree;

import com.cn.Algorithm.dataStructure.tree.TreeNode;

import java.util.ArrayList;
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
        pro_recursion(test);
        System.out.println();
        mid(test);
        System.out.println();

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
        }
    }

    public static void back(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = treeNode;
        while (!stack.isEmpty()){

        }

    }

    public static void pro_recursion(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()){
            //首先压入根节点，每次弹出栈中第一个节点，它的左右孩子不为空就压入栈
            //前序是根 左 右的顺序，先压右再压左，每次弹出的都是根节点左孩子一直往下，就是根 左的效果
            //右节点保存在栈中，随后面弹出，就是把状态保存在栈里等到要处理再使用，达到这种效果
            TreeNode pop = stack.pop();
            System.out.print(pop.val + " ");
            if(pop.right != null){
                stack.push(pop.right);
            }
            if(pop.left != null){
                stack.push(pop.left);
            }
        }
    }

    public static void mid_recursion(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()){
            while (treeNode != null){
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
//            TreeNode pop = stack.pop();
//            System.out.println(pop.val);
//            if(pop.right != null){
//                stack.push(pop.right);
//            }
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                System.out.print(treeNode.val + " ");
                treeNode = treeNode.right;
            }
        }
    }
}
