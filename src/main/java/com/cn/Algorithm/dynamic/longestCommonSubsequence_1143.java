package com.cn.Algorithm.dynamic;

import com.cn.Algorithm.util.printUtils;

/**
 * 类名: longestCommonSubsequence_1143
 * 描述: 1143. 最长公共子序列
 * 姓名: @author南风
 * 日期: 2022-02-23 17:33
 **/
public class longestCommonSubsequence_1143 {
    public static void main(String[] args) {
        String test = "abc";
        String test2 = "zebfc";
        System.out.println(longestCommonSubsequence1(test, test2));
    }

    /**
    *功能描述:1143. 最长公共子序列
    *@param text1
    *@param text2
    *@return int
    **/
    public static int longestCommonSubsequence1(String text1, String text2) {
        int M = text1.length();
        int N = text2.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            printUtils.printArray(dp);
            System.out.println("----------");
        }
        return dp[M][N];
    }


    /**
    *功能描述:我的版本 问题在于 不能找到公共的子序列，如果第一个字母不相等的版本就没办法了，
    *@param text1
    *@param text2
    *@return int
    **/
    public static int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] arr = new int[n1][n2];
        arr[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        for (int i = 1; i < n1; i++) {
            arr[0][i] = text1.charAt(0) == text2.charAt(i) ? arr[0][i - 1] + 1 : arr[0][i - 1];
        }
        for (int i = 1; i < n2; i++) {
            arr[0][i] = text2.charAt(i) == text1.charAt(0) ? arr[0][i - 1] + 1 : arr[0][i - 1];
        }
        printUtils.printArray(arr);
        System.out.println();
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                arr[i][j] = text1.charAt(i) == text2.charAt(j) ? arr[i - 1][j - 1] + 1 : arr[i][j - 1];
            }
        }
        printUtils.printArray(arr);
        System.out.println();
        return arr[n1 - 1][n2 - 1];
    }
}
