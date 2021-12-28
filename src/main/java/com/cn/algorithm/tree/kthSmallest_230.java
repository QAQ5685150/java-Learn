package com.cn.algorithm.tree;

import com.cn.algorithm.dataStructure.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 类名:kthSmallest_230
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-10-18 13:44
 **/
public class kthSmallest_230 {

    private static Stack<Integer> stack = new Stack<>();

    private static int ans;

    public static int kthSmallest(TreeNode root, int k) {
        process(root,k);
        return ans;
    }

    public static void process(TreeNode root,int k){
        if(root == null){
            return;
        }
        process(root.left,k);
        stack.push(root.val);
        if(stack.size() == k){
            ans = stack.pop();
            return;
        }
        process(root.right,k);
    }

    public static int kthSmallest_unrecursion(TreeNode treeNode,int k){
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (treeNode != null || !deque.isEmpty()){
            while (treeNode !=null){
                deque.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode = deque.pop();
            k--;
            if(k == 0){
                break;
            }
            treeNode = treeNode.right;
        }
        return treeNode.val;
    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode(3,new TreeNode(1,null,new TreeNode(2)),new TreeNode(4));
        //System.out.println(kthSmallest(test, 1));
        System.out.println(kthSmallest_unrecursion(test,1));
    }
}
