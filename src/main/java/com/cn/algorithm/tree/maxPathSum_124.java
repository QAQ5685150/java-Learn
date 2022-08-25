package com.cn.algorithm.tree;

import com.cn.algorithm.dataStructure.tree.TreeNode;

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
        dfs(root);
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
}
