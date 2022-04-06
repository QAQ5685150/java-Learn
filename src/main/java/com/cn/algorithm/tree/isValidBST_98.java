package com.cn.algorithm.tree;


/**
 * 类名:isValidBST_98
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-23 17:20
 **/
public class isValidBST_98 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,new TreeNode(1),new TreeNode(4,new TreeNode(3),new TreeNode(6)));
        TreeNode root2 = new TreeNode(2,new TreeNode(1),new TreeNode(3));
        System.out.println(isValidBST2(root));

    }

    public static boolean isValidBST(TreeNode root) {
        return process(root);
    }

    public static boolean process(TreeNode root){
        if(root == null){
            return true;
        }
        if(root.val <= root.left.val || root.val >= root.right.val){
            return false;
        }
        process(root.left);
        process(root.right);
        return true;
    }

    public static boolean isValidBST2(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return  validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
