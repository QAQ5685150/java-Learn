package com.cn.algorithm.dynamic;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.dynamic
 * @Time: 2022-08-23 15:35
 * @Description: TODO
 **/
public class minDistance_72 {

    public static void main(String[] args) {
        System.out.println(minDistance("horse","ros"));
    }

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len2 + 1][len1 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len2; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len2; i++) {
            for (int j = 1; j <= len1; j++) {
                char c1 = word1.charAt(j - 1);
                char c2 = word2.charAt(i - 1);
                int left = dp[i][j-1] + 1;
                int down = dp[i-1][j] + 1;
                int left_down = dp[i-1][j-1] + 1;
                if(c1 != c2) left_down += 1;
                dp[i][j] = Math.min(left,Math.min(down,left_down));
            }
        }
        return dp[len2][len1];
    }
}
