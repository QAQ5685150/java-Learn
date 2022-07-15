package com.cn.algorithm.backtrack;

import com.cn.algorithm.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.backtrack
 * @Time: 2022-07-12 16:12
 * @Description: Â·¾¶×ÜºÍ
 **/
public class pathSum {

    public static void main(String[] args) {

    }

    List<List<Integer>> res = new ArrayList<>();

    Deque<Integer> list = new LinkedList<>();

    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
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
