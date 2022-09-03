package com.cn.Algorithm.search.dfs;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-09-03 16:52
 * @Description: JZ13 机器人的运动范围
 * @Project_name: java-learn
 */
public class movingCount {

    static int count = 0;

    public static void main(String[] args) {
        System.out.println(movingCount(10, 1, 100));
    }

    public static int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows + 1][cols + 1];
        backtrack(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    public static void backtrack(int threshold, int rows, int cols, int i, int j,boolean[][] visited){
        if(i < 0 || i >= rows || j < 0 || j >= cols || check(threshold,i,j)){
            return;
        }
        if(!visited[i][j]){
            count++;
        }
        visited[i][j] = true;
        backtrack(threshold, rows, cols, i + 1, j,visited);
        backtrack(threshold, rows, cols, i, j + 1,visited);
    }

    private static boolean check(int threshold, int i, int j) {
        int val = 0;
        while (i > 0){
            val += i % 10;
            i /= 10;
        }
        while (j > 0){
            val += j % 10;
            j /= 10;
        }
        return threshold < val;
    }
}
