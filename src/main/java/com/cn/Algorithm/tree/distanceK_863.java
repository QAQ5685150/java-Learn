package com.cn.Algorithm.tree;

import java.util.*;

import com.cn.Algorithm.dataStructure.tree.TreeNode;

/**
 * 类名: distanceK_863
 * 描述: TODO
 * 姓名: @author南风
 * 日期: 2022-02-17 16:49
 **/
public class distanceK_863 {

    public static Map<Integer,TreeNode> map = new HashMap<>();

    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode testData = TreeNode.getTestData();
        review(testData,2);
    }


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfsparent(root);

        dfsans(target,null,k,0);

        return list;
    }

    private void dfsans(TreeNode target, TreeNode from, int k, int i) {
        if(target == null){
            return;
        }

        if(k == i){
            list.add(target.val);
        }

        if(target.left != null){
            dfsans(target,from,k,i + 1);
        }

        if(target.right != null){
            dfsans(target, from, k, i + 1);
        }

        //map保存了所有节点的父节点（条件有所有节点不重复）
        //target节点不是从root节点开始，可能从左子树上某个节点或右子树某个节点
        //这时候和target距离为k的节点，就不仅仅包括target往下k个节点，还有可能在右子树上，这时候就要向上遍历去找
        //map.get(target.val) 就是拿到了hashMap中存好的父节点，完成往上遍历的动作
        if(map.get(target.val) != from){
            dfsans(map.get(target.val), from, k, i + 1);
        }

    }

    private void dfsparent(TreeNode root) {
        if (root.left != null){
            map.put(root.left.val, root);
            dfsparent(root.left);
        }
        if(root.right != null){
            map.put(root.right.val, root);
            dfsparent(root.right);
        }
    }

    private static HashMap<Integer, TreeNode> nodeHashMap = new HashMap<>();

    private static List<Integer> ans = new ArrayList<>();

    public static void review(TreeNode root, int k){
        dfeMap(root);
        dfs(root,null,k,0);
        for (Integer an : ans) {
            System.out.print(an + " ");
        }
    }

    public static void dfeMap(TreeNode root){
        if(root.left != null){
            nodeHashMap.put(root.left.val,root);
            dfeMap(root.left);
        }
        if(root.right != null){
            nodeHashMap.put(root.right.val,root);
            dfeMap(root.right);
        }
    }

    public static void dfs(TreeNode root, TreeNode from, int k, int index){
        if(root == null){
            return;
        }
        if(index == k){
            ans.add(root.val);
        }
        if(root.left != null){
            dfs(root.left,root,k,index + 1);
        }
        if(root.right != null){
            dfs(root.right,root,k,index + 1);
        }
        if(nodeHashMap.get(root.val) != from){
            dfs(nodeHashMap.get(root.val),from,k,index + 1);
        }
    }

}
