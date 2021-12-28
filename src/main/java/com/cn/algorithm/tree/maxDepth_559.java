package com.cn.algorithm.tree;

import com.cn.algorithm.dataStructure.tree.NTreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 类名:maxDepth_559
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-22 9:49
 **/
public class maxDepth_559 {

    private static int ans = 0;

    public static void main(String[] args) {
        NTreeNode root = new NTreeNode(1,
                Arrays.asList(new NTreeNode(3,
                        Arrays.asList(new NTreeNode(5),new NTreeNode(6))),
                        new NTreeNode(2),new NTreeNode(4)));

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(NTreeNode root) {
        return process(root);
    }

    public static int process(NTreeNode root){
        Queue<NTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                NTreeNode poll = queue.poll();
                if(poll.children != null){
                    for (int i = 0; i < poll.children.size(); i++) {
                        queue.add(poll.children.get(i));
                    }
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
