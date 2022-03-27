package com.cn.algorithm.dynamic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-03-26 14:29
 * @Description: TODO
 * @Project_name: java-learn
 */
public class LIS_dp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] test = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            test[i] = Integer.valueOf(s[i]);
        }
        System.out.println(LIS(test));
    }

    public static int LIS(int[] arr){
        int len = arr.length;
        int[] dp = new int[len + 1];
        int max = 0;
        Arrays.fill(dp,1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
}
