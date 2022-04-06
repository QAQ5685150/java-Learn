package com.cn.algorithm.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cn.algorithm.dataStructure.tree.TreeNode;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-04-06 13:56
 * @Description: TODO
 * @Project_name: java-learn
 */
public class findDuplicateSubtrees_652 {

    public static Map<String,Integer> map = new HashMap<>();

    public static List<TreeNode> ans = new ArrayList<>();

    public static void main(String[] args) {

    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        process(root);
        return ans;
    }

    public static String process(TreeNode root){
        if(root == null){
            return "#";
        }
        String cur = root.val + "," + process(root.left) + "," + process(root.right);
        map.put(cur,map.getOrDefault(cur,0) + 1);
        if(map.get(cur) >= 2){
            ans.add(root);
        }
        return cur;
    }
}
