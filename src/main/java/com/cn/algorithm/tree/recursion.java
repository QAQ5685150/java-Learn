package com.cn.algorithm.tree;

import com.cn.algorithm.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名:recursion
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-28 14:20
 **/
public class recursion {

    public List<Integer> re_proList = new ArrayList<>();
    public List<Integer> re_midList = new ArrayList<>();
    public List<Integer> re_backList = new ArrayList<>();

    public void pro(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        re_proList.add(treeNode.val);
        pro(treeNode.left);
        pro(treeNode.right);
    }

    public void mid(TreeNode treeNode){
        if(treeNode == null){
            return;
        }

        pro(treeNode.left);
        re_midList.add(treeNode.val);
        pro(treeNode.right);
    }

    public void back(TreeNode treeNode){
        if(treeNode == null){
            return;
        }

        pro(treeNode.left);
        pro(treeNode.right);
        re_backList.add(treeNode.val);
    }
}
