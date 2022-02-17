package com.cn.algorithm.tree;

import com.cn.algorithm.dataStructure.tree.TreeNode;

import java.util.*;

/**
 * 类名:Codec_297
 * 描述:297. 二叉树的序列化与反序列化
 * 姓名:南风
 * 日期:2021-11-22 13:37
 **/
public class Codec_297_zzz {

// test data
//             21
//        7            14
//     1     1      2       2
// 3     3
    public static void main(String[] args) {
        TreeNode test = new TreeNode(21,
                new TreeNode(7, new TreeNode(1, new TreeNode(3), new TreeNode(3)),
                        new TreeNode(1)),
                new TreeNode(14, new TreeNode(2),
                        new TreeNode(2)));
        String serialize = serialize(test);
        System.out.println(serialize);
        TreeNode deserialize = deserialize(serialize);
        System.out.println(deserialize);
        Collections.shuffle(new ArrayList<>());

    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null){
            return "#!";
        }
        String data = String.valueOf(root.val) + "!";
        data += serialize(root.left);
        data += serialize(root.right);
        return data;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        String[] split = data.split("!");
        for (String s : split) {
            System.out.print(s + " ");
            queue.add(s);
        }

        return deHelper(queue);
    }

    public static TreeNode deHelper(Queue<String> queue){
        String poll = queue.poll();
        if(poll.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(poll));
        root.left = deHelper(queue);
        root.right = deHelper(queue);
        return root;
    }
}
