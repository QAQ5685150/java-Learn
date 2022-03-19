package com.cn.algorithm.tree;

import com.cn.algorithm.dataStructure.tree.TreeNode;

import java.util.Stack;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-03-19 12:49
 * @Description: TODO
 * @Project_name: java-learn
 */
public class tree2string {

    private static String ans = "";

    public static void main(String[] args) {
        TreeNode testData = TreeNode.getTestData();
        //tree2str(testData);
        System.out.println(tree2str_unRecursion(testData));
    }

    public static void tree2str(TreeNode root) {
        if(root == null){
            return ;
        }

        ans += "(";
        ans += String.valueOf(root.val);
        tree2str(root.left);
        tree2str(root.right);
        ans += ")";
    }


    /**
     * �ݹ� ��׼��
     * @param root
     * @return
     */
    public static String _tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return Integer.toString(root.val);
        }
        if (root.right == null) {
            return new StringBuffer().append(root.val).append("(").append(_tree2str(root.left)).append(")").toString();
        }
        return new StringBuffer().append(root.val).append("(").append(_tree2str(root.left)).append(")(").append(_tree2str(root.right)).append(")").toString();
    }

    /**
     * tree �ǵݹ�review
     * @param root
     * @return
     */
    public static String tree2str_unRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            stringBuilder.append(pop.val).append(" ");
            if(pop.right != null){
                stack.push(pop.right);
            }
            if(pop.left != null){
                stack.push(pop.left);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * ����˼·
     * @param root
     * @return
     */
    public static String tree2str_unRecursion2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            stringBuilder.append(pop.val).append(" ");
            if(pop.right != null){
                stack.push(pop.right);
            }
            if(pop.left != null){
                stack.push(pop.left);
            }
        }
        return stringBuilder.toString();
    }
}
