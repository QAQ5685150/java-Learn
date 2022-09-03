package com.cn.Algorithm.algoritmBook.august;

import com.cn.Algorithm.dataStructure.tree.TreeNode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.algoritmBook
 * @Time: 2022-08-04 17:03
 * @Description: 每日错题回顾 day01
 **/
public class day08_04 implements Serializable {

    public static void main(String[] args) {
        TreeNode testData = TreeNode.getTestData();
        mid(testData);

        System.out.println(serialized(testData));
    }

    /**
     * 树的非递归中序遍历
     * @param root
     */
    public static void mid(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            while (root.left != null){
                stack.push(root.left);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val + " ");
            if(root.right != null){
                root = root.right;
                stack.push(root);
            }
        }
    }

    /**
     * hash 两数之和
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum (int[] numbers, int target) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < numbers.length; i++){
            map.put(numbers[i], i + 1);
        }
        for(int i = 0; i < numbers.length; i++){
            if(map.containsKey(target - numbers[i])){
                res[0] = i + 1;
                res[1] = map.get(target - numbers[i]);
                break;
            }
        }
        return res;
    }


    public static String serialized(TreeNode node){
        if (node == null){
            return "#!";
        }
        String res = node.val + "#";
        res += serialized(node.left);
        res += serialized(node.right);
        return res;
    }

    public static TreeNode deSerialized(String serial){


        return helper();
    }

    public static TreeNode helper(){
        TreeNode root = new TreeNode();


        return root;
    }

}
