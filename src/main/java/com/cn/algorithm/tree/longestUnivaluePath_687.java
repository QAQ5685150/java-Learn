package com.cn.algorithm.tree;

import com.cn.algorithm.dataStructure.tree.TreeNode;

import java.util.HashMap;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.tree
 * @Time: 2022-09-02 9:05
 * @Description: 687. 最长同值路径
 **/
public class longestUnivaluePath_687 {

    public static void main(String[] args) {
        longestUnivaluePath_687 l = new longestUnivaluePath_687();
        TreeNode node = TreeNode.getTestData();
        System.out.println(l.longestUnivaluePath(node));
    }

    int count = 0;
    public int __longestUnivaluePath(TreeNode root) {
        //dfsParent(map,root);
        __dfs(root,root.val,0);
        return count;
    }

    public void __dfs(TreeNode root,int k,int sum){
        if(root == null){
            return ;
        }
        int cur = sum;
        if(root.left != null && root.left.val == k){
            cur += 1;
            count = Math.max(cur,count);
            __dfs(root.left,k,cur);
        }
        if(root.left != null && root.left.val == k){
            cur += 1;
            count = Math.max(cur,count);
            __dfs(root.left,k,cur);
        }
        __dfs(root.left,root.val,0);
        __dfs(root.right,root.val,0);
    }

    int max = 0;

    /**
     * 三叶题解 和我的思路挺像
     * @param root
     * @return
     */
    public int _longestUnivaluePath(TreeNode root) {
        _dfs(root);
        return Math.max(0, max - 1);
    }
    int _dfs(TreeNode root) {
        if (root == null) return 0;
        int ans = 1, cur = 1, l = _dfs(root.left), r = _dfs(root.right);
        if (root.left != null && root.val == root.left.val) {
            ans = l + 1; cur += l;
        }
        if (root.right != null && root.val == root.right.val) {
            ans = Math.max(ans, r + 1); cur += r;
        }
        max = Math.max(max, cur);
        return ans;
    }


    /**
     * 官方题解
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        dfs(root,root.val);
        return count;
    }

    public int dfs(TreeNode root, int val){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left,root.val);
        int right = dfs(root.right,root.val);
        count = Math.max(count, left + right);
        if(root.val == val){
            return Math.max(left,right) + 1;
        }
        return 0;
    }

}
