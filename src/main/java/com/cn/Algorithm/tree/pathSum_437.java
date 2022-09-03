package com.cn.Algorithm.tree;
import com.cn.Algorithm.dataStructure.tree.TreeNode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 类名:pathSum_437
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-28 11:26
 **/


public class pathSum_437 {
    static int ans = 0;

    public static void main(String[] args) {

        TreeNode test = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)),
                        new TreeNode(0, new TreeNode(), new TreeNode())),
                new TreeNode(8, new TreeNode(13, new TreeNode(5), new TreeNode(1)),
                        new TreeNode(4)));

        System.out.println(pathSum(test, 22));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        Integer[] integers = new Integer[]{3,5,6,72,4,2,5,12,3,12,4,34};

        Arrays.sort(integers,(a,b) -> b - a);

        Arrays.stream(integers).forEach(integer -> System.out.print(integer + " "));

    }

    public static int pathSum(TreeNode root, int targetSum) {
        process(root, targetSum);
        return ans;
    }

    public static void process(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        dfs(root,root.val,targetSum);
        process(root.left, targetSum);
        process(root.right, targetSum);
    }

    public static void dfs(TreeNode root,int value, int target){
        if(value == target){
            ans++;
            return;
        }
        if(root.left != null) dfs(root.left,value + root.left.val,target);
        if(root.right != null) dfs(root.right,value + root.right.val,target);
    }


}


