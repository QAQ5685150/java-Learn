package com.cn.Algorithm.algoritmBook.niuke;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.algoritmBook.niuke
 * @Time: 2022-09-13 13:30
 * @Description: 牛客动态规划专题 连续子数组的最大乘积
 **/
public class DP7 {

    public static void main(String[] args) {
        int[] test = new int[]{3,2,5,-2,-4,5,6};
        System.out.println(dp(test));
    }

    //3 2 -2 4 5
    //3 2 -2 4 5 -4
    //3 2 -1 4 5 3
    public static int dp(int[] arr){
        int len = arr.length;
        int[] dp = new int[len];
        int pre_max = arr[0];
        int pre_min = arr[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            int cur_max = Math.max(pre_max,Math.max(pre_max * arr[i],pre_min * arr[i]));
            int cur_min = Math.min(pre_min,Math.min(pre_max * arr[i],pre_min * arr[i]));
            res = Math.max(res,cur_max);
            pre_max = cur_max;
            pre_min = cur_min;
        }
        return res;
    }
}
