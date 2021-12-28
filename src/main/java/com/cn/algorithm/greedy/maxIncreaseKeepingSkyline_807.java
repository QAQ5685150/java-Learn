package com.cn.algorithm.greedy;

/**
 * @class: maxIncreaseKeepingSkyline_807
 * @description: TODO
 * @author: 南风
 * @date: 2021-12-13 14:08
 **/
public class maxIncreaseKeepingSkyline_807 {

    public static void main(String[] args) {
        int[][] test = new int[][]{{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(maxIncreaseKeepingSkyline(test));
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] tmp = new int[row][col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tmp[i][j] = process(grid,i,j);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans += tmp[i][j] - grid[i][j];
            }
        }
        return ans;
    }

    public static int process(int[][] grid, int i, int j){
        int maxRow = 0;
        int maxCol = 0;
        for (int k = 0; k < grid.length; k++) {
            maxRow = Math.max(grid[k][j], maxRow);
        }
        for (int k = 0; k < grid[0].length; k++) {
            maxCol = Math.max(grid[i][k], maxCol);
        }
        return Math.min(maxRow,maxCol);
    }
}
