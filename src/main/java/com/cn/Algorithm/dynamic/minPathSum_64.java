package com.cn.Algorithm.dynamic;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.dynamic
 * @Time: 2022-09-30 10:33
 * @Description: TODO
 **/
public class minPathSum_64 {

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(test));
    }

    public static int minPathSum(int[][] grid) {
        int col = grid.length;
        int row = grid[0].length;
        int[][] dp = new int[col][row];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < col; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            for (int j = 1; j < row; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[col - 1][row - 1];
    }
}
