package com.cn.algorithm.dfs;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.dfs
 * @Time: 2022-07-08 11:19
 **/
public class numIslands_200 {

    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {
        int length = grid.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(grid[i][j] == '1'){
                    replace(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void replace(char[][] grid, int i, int j){
        if(i < 0 || i > grid[0].length || j < 0 || j > grid.length || grid[i][j] != '1'){
            return ;
        }
        grid[i][j] = '0';
        replace(grid,i + 1, j + 1);
        replace(grid,i - 1, j - 1);
        replace(grid,i + 1, j - 1);
        replace(grid,i - 1, j + 1);
    }
}
