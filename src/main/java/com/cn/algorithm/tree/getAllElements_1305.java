package com.cn.algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.cn.algorithm.dataStructure.tree.TreeNode;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-05-01 11:15
 * @Description: TODO
 * @Project_name: java-learn
 */
public class getAllElements_1305 {

    List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,5,6,8,23,6,4,5,78,56,7,8,43,45,6,5,7);
        sort(list);
        list.forEach( x -> System.out.print(x + " "));
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        pre(root1);
        pre(root2);
        Collections.sort(ans);
        return ans;
    }

    public void pre(TreeNode treeNode){
        if (treeNode ==  null){
            return ;
        }
        pre(treeNode.left);
        ans.add(treeNode.val);
        pre(treeNode.right);
    }

    public static void sort(List<Integer> list){
        int left = 0;
        int right = list.size() - 1;
        mergeSort(list,left,right);
    }

    public static void mergeSort(List<Integer> list,int l,int r){
        if(l == r){
            return;
        }
        int mid = ((r - l) >> 1) + l;
        mergeSort(list,l,mid);
        mergeSort(list,mid + 1,r);
        merge(list,l,r);
    }

    public static void merge(List<Integer> list,int l,int r){
        int[] helper = new int[r - l + 1];
        int p1 = l;
        int mid = ((r - l) >> 1) + l;
        int p2 = mid + 1;
        int index = 0;
        while (p1 <= mid && p2 <= r){
            helper[index++] = list.get(p1) < list.get(p2) ? list.get(p1++) : list.get(p2++);
        }
        while (p1 <= mid){
            helper[index++] = list.get(p1++);
        }
        while (p2 <= r){
            helper[index++] = list.get(p2++);
        }
        for (int i = 0; i < helper.length; i++) {
            list.set(l + i,helper[i]);
        }
    }

}
