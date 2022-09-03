package com.cn.Algorithm.tree;

import com.cn.Algorithm.dataStructure.tree.TreeNode;

/**
 * 类名:findTilt_563
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-18 10:19
 **/
public class findTilt_563 {

    private static int sum = 0;

    public static int findTilt(TreeNode root) {
        if(root.left == null && root.right == null){
            return 0;
        }
        findTilt(root.left);
        findTilt(root.right);
        int left = root.left == null ? 0 : root.left.val;
        int right = root.right == null ? 0 : root.right.val;
        root.val += left + right;
        sum += Math.abs(left - right);
        return root.val;
    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode(21,
                new TreeNode(7, new TreeNode(1, new TreeNode(3), new TreeNode(3)),
                        new TreeNode(1)),
                new TreeNode(14, new TreeNode(2),
                        new TreeNode(2)));
        int tilt = findTilt(test);
        System.out.println(sum);
    }
}