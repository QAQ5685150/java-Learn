package com.cn.Algorithm.tree;

import com.cn.Algorithm.dataStructure.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-04-17 20:33
 * @Description: TODO
 * @Project_name: java-learn
 */
public class buildTree_106 {

    int[] post;
    int[] in;
    int cur;
    Map<Integer,Integer> index = new HashMap<>();


    public static void main(String[] args) {
        buildTree_106 buildTree = new buildTree_106();
        int[] postorder = new int[]{};
        int[] inorder = new int[]{};
        TreeNode treeNode = buildTree.buildTree(postorder, inorder);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] postorder, int[] inorder){
        this.post = postorder;
        this.in = inorder;
        int index = 0;
        cur = postorder.length - 1;
        for (int i = 0; i < postorder.length; i++) {
            this.index.put(postorder[i], index++);
        }
        return helper(0,postorder.length - 1);
    }

    public TreeNode helper(int left_index, int right_index){
        if(left_index > right_index){
            return null;
        }

        int index = this.index.get(post[cur]);
        TreeNode root = new TreeNode(post[cur]);
        cur--;

        root.right = helper(index + 1,right_index);
        root.left = helper(left_index, index - 1);
        return root;
    }
}
