package com.cn.Algorithm.tree;

import com.cn.Algorithm.dataStructure.tree.TreeNode;

/**
 * 类名: findSecondMinimumValue_671
 * 描述: TODO
 * 姓名: @author南风
 * 日期: 2022-02-17 11:33
 **/
public class findSecondMinimumValue_671 {

    public static void main(String[] args) {
        TreeNode testData = TreeNode.getTestData();
        System.out.println(findSecondMinimumValue(testData));
    }

    public static int findSecondMinimumValue(TreeNode root) {
        return helper(root,root.val);
    }

    public static int helper(TreeNode root,int minVal){
        //叶子端点
        if(root==null){
            return -1;
        }
        //如果当前结点值>根节点，那么不用再遍历它的子节点，直接返回该值
        if(root.val>minVal){
            return root.val;
        }

        //否则，即当前结点值==根节点,则需要在两棵子树找目标值结点
        int l=helper(root.left,minVal);
        int r=helper(root.right,minVal);
        //如果两棵子树均存在大于最小值的节点，那么返回较小的那一个
        if(l!=-1&&r!=-1){
            return Math.min(l,r);
        }else{//否则，其余情况均返回较大的那一个
            return Math.max(l,r);
        }
    }
}
