package com.cn.Algorithm.backtrack;

import com.cn.Algorithm.util.printUtils;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.array
 * @Time: 2022-09-08 9:17
 * @Description: 优美的排列Ⅰ、Ⅱ leetcode.667
 **/
public class constructArray_667 {
    static int count = 0;

    //打表法，求出所有答案，放在数组里返回，需要看题目条件给答案
    int[] arr = new int[]{0,1,2,3,8,10,36,41,132,250,700,750,4010,4237,10680,24679};
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i <= 15; i++) {
//            int num = countArrangement(i);
//            count = 0;
//            list.add(num);
//        }
//        System.out.println(countArrangement(5));
//        printUtils.printArray(list);
        int[] ints = constructArray(3, 2);
        if(ints != null) printUtils.printArray(ints);
    }
    static int[] res = null;
    public static int[] constructArray(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        backtrack(arr,0,k);
        return res;
    }

    public static void backtrack(int[] arr, int i, int k){
        if(i == arr.length){
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < arr.length - 1; j++) {
                int abs = Math.abs(arr[j + 1] - arr[j]);
                set.add(abs);
            }
            if(set.size() == k) {
                int index = 0;
                res = new int[arr.length];
                for (int i1 : arr) {
                    res[index++] = i1;
                }
            }
            return;
        }
        if(res == null){
            for (int j = i; j < arr.length; j++) {
                swap(arr, i, j);
                backtrack(arr,i + 1, k);
                swap(arr, j, i);
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int countArrangement(int n) {
        //dfs(n,1,new LinkedList<>(),new boolean[n + 1]);
        dfs_cut(1,n,new boolean[n + 1]);
        return count;
    }

    /**
     * 模拟全排列，判断每个排列是否符合
     * @param n
     * @param i
     * @param que
     * @param visited
     */
    public static void dfs(int n, int i,  LinkedList<Integer> que, boolean[] visited){
        if(i == n + 1){
            boolean f1 = false;
            boolean f2 = false;
            int index = 0;
            for (int j = 0; j < que.size(); j++) {
                if(!f1 && que.get(j) % (j + 1) == 0) f1 = true;
                if(!f2 && (j + 1) %  que.get(j)== 0) f2 = true;
            }
            if(f1 && f2) count++;
            return;
        }
        for (int j = 1; j <= n; j++) {
            if(visited[j]) continue;
            visited[j] = true;
            que.addLast(j);
            dfs(n,i + 1,que,visited);
            visited[j] = false;
            que.removeLast();
        }
    }

    /**
     * 剪枝算法 不符合情况的“去除”不参与递归，类似于visited数组
     * @param step
     * @param n
     * @param visited
     */
    public static void dfs_cut(int step, int n, boolean[] visited){
        if(step == n + 1){
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            if(step % i == 0 || i % step == 0){
                dfs_cut(step + 1, n,visited);
            }
            visited[i] = false;
        }
    }

}
