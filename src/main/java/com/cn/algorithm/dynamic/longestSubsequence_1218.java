package com.cn.algorithm.dynamic;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 类名:longestSubsequence_1218
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-05 17:58
 **/
public class longestSubsequence_1218 {

    /**
     * 给你一个整数数组arr和一个整数difference，请你找出并返回 arr中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
     *
     * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
    **/
    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4};
        int dif = 1;
        System.out.println(longestSubsequence_right(test, dif));
    }

    public static int longestSubsequence_xxx(int[] arr, int difference) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length; i++){
            int num = 0;
            int cur = arr[i] + difference;
            while (!set.contains(cur)){
                cur = cur + difference;
                num++;
            }
            max = Math.max(max,num);
        }
        return max;
    }

    /**
    *功能描述:动态规划
    *@param arr
    *@param difference
    *@return int
    **/
    public static int longestSubsequence_right(int[] arr, int difference) {
        int max = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i - difference,0) + 1);
            max = Math.max(max, map.get(i));
        }
        return max;
    }

    /**
    *功能描述:dp
     *和hash一样的思路，遍历到当前数去找当前 - dif在辅助hash\数组里是否存在，
     * 存在结果加1，对所有数执行该操作，
     * dp -> 找到重叠子问题、找到最优子结构
    *@param ints
    *@param dif
    *@return int
    **/
    public int longestSubsequence2(int[] ints, int dif) {
        int[] arr = new int[40001];
        int d = 20000;
        int max = 0;
        for (int anInt : ints) {
            arr[d + anInt] = arr[d + anInt - dif] + 1;
            max = Math.max(max,arr[d + anInt]);
        }
        return max;
    }
}
