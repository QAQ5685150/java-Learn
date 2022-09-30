package com.cn.Algorithm.tree;

import com.cn.Algorithm.dataStructure.tree.TreeNode;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.tree
 * @Time: 2022-08-24 17:05
 * @Description: TODO
 **/
public class maxPathSum_124 {

    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTestData();
        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        System.out.println(dfs(root));
        return max;
    }

    public static int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(0,dfs(root.left));
        int right = Math.max(0,dfs(root.right));
        max = Math.max(max,left + right + root.val);
        return left + right + root.val;
    }

    static int res = Integer.MIN_VALUE;
    public static int maxPathSum_review(TreeNode root) {
        if(root == null) return 0;
        process(root);
        return res;
    }

    public static int process(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = process(root.left);
        int right = process(root.right);
        max = Math.max(max,right + left + root.val);
        return Math.max(left,right) + root.val;
    }
}
