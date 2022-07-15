package com.cn.algorithm.tree;

import com.cn.algorithm.dataStructure.tree.TreeNode;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.tree
 * @Time: 2022-07-15 11:17
 * @Description: TODO
 **/
public class diameterOfBinaryTree_543 {

    public static void main(String[] args) {

    }

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max,left + right);
        //不一定穿过根节点，所以从左右孩子节点取最大值+count返回
        return Math.max(left,right)+ 1;
    }
}
