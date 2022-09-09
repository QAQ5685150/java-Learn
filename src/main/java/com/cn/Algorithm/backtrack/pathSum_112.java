package com.cn.Algorithm.backtrack;

import com.cn.Algorithm.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.backtrack
 * @Time: 2022-07-12 16:12
 * @Description: 路径总和
 **/
public class pathSum_112 {

    public static void main(String[] args) {

    }

    /**
     * leetcode.112 路径总和 二叉树递归 + 条件判断
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum1_112(TreeNode root, int targetSum) {
        if(root == null) return false;
        return dfs(root,targetSum);
    }

    public boolean dfs(TreeNode root, int targetSum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return targetSum - root.val == 0;
        }
        return dfs(root.left,targetSum - root.val) || dfs(root.right,targetSum - root.val);
    }

    List<List<Integer>> res = new ArrayList<>();

    Deque<Integer> list = new LinkedList<>();

    /**
     * leetcode.113 路径总和2 回溯 + 递归
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum2_113(TreeNode root, int targetSum) {
        process(root,targetSum);
        return res;
    }

    public void process(TreeNode root, int target){
        if(root == null){
            return;
        }
        list.offerLast(root.val);
        target -= root.val;
        if(root.left == null && root.right == null && target == 0){
            res.add(new ArrayList<>(list));
        }
        process(root.left,target);
        process(root.right,target);
        list.pollLast();
    }

}
