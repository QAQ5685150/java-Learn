package com.cn.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @class: colorBorder_1034
 * @description: 1034. 边界着色
 * @author: 南风
 * @date: 2021-12-07 9:52
 **/
public class colorBorder_1034 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,2,},{2,3,2}};
        int[][] ints = colorBorder(arr, 0, 1, 3);

        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        process(grid,row,col,color,grid[row][col]);
        return grid;
    }

    public static void process(int[][] grid, int row, int col, int color,int num){
        if(row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1) {
            return;
        }
        if(grid[row][col] == num){
            grid[row][col] = color;
        }else return;
        process(grid,row+1,col,color,grid[row][col]);
        process(grid,row,col + 1,color,grid[row][col]);
        process(grid,row - 1,col,color,grid[row][col]);
        process(grid,row,col - 1,color,grid[row][col]);
    }


    /**
     *功能描述:dfs遍历
     **/
    private static int[] dirs = new int[]{
            -1,0,1,0,-1
    };
    public static int[][] colorBorder1(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        dfs(grid, visited, row, col, grid[row][col], color);
        return grid;
    }

    private static boolean dfs(int[][] grid, boolean[][] visited, int row, int col, int color, int rep) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return true;
        if (visited[row][col]) return false;
        if (grid[row][col] != color) return true;
        visited[row][col] = true;
        boolean canFill = false;
        for (int i = 0; i < 4; i++) {
            canFill |= dfs(grid, visited, row + dirs[i], col + dirs[i + 1], color, rep);
        }
        if (canFill) grid[row][col] = rep;
        return false;
    }

    /**
     *功能描述:bfs
     *@paramgr id
     *@param row
     *@param col
     *@param color
     *@return int[][]
     **/
    public int[][] colorBorder3(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m][n];
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        Deque<int[]> d = new ArrayDeque<>();
        d.addLast(new int[]{row, col});
        while (!d.isEmpty()) {
            int[] poll = d.pollFirst();
            int x = poll[0], y = poll[1], cnt = 0;
            for (int[] di : dirs) {
                int nx = x + di[0], ny = y + di[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (grid[x][y] != grid[nx][ny]) continue;
                else cnt++;
                if (ans[nx][ny] != 0) continue;
                d.addLast(new int[]{nx, ny});
            }
            ans[x][y] = cnt == 4 ? grid[x][y] : color;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == 0) ans[i][j] = grid[i][j];
            }
        }
        return ans;
    }

}
