package com.cn.algorithm.competition;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-04-26 10:10
 * @Description: TODO
 * @Project_name: java-learn
 */
public class leetcode_289 {

    public static void main(String[] args) {
        System.out.println(process_dp(9));

    }

    /**
     *
     * @param s
     * @param k
     * @return
     */
    public static String digitSum(String s, int k) {
        int length = s.length();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > k){
            StringBuilder ss = new StringBuilder();
            int times = sb.length() % k == 0 ? sb.length() / k : sb.length() / k + 1;
            for (int i = 0; i < times; i++) {
                int tmp = 0;
                int index = i * k;
                int n = 0;
                while (index < sb.length() && n < k){
                    tmp += Integer.valueOf(sb.charAt(index) - '0');
                    index++;
                    n++;
                }
                ss.append(tmp);
            }
            sb = ss;
        }
        return sb.toString();
    }

    public static int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task,map.getOrDefault(task,0) + 1);
        }
        int ans = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer cur = next.getValue();
            if(cur == 1){
                return -1;
            }
            ans += process_dp(cur);
        }
        return ans;
    }

    /**
     * 动态规划 找当前数n -2或-3的两种选择，需要的最少次数 自底向上
     * @param n
     * @return
     */
    public static int process_dp(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n; i++) {
            dp[i] = Math.min(dp[i - 2] + 1,dp[i - 3] + 1);
        }
        return dp[n - 1];
    }


    /**
     * 递归判断当前数字每次 -2或-3 完成的最小次数
     * @param n
     * @param times
     * @return
     */
    public static int process_recursion(int n,int times){
        if(n <= 0){
            return times;
        }
        return Math.min(process_recursion(n - 3,times + 1),process_recursion(n - 2,times + 1));
    }

    public static int maxTrailingZeros(int[][] grid) {




        return 0;
    }

    public static int process_dfs(int[][] grid, int i, int j, boolean[][] visited, int res, int curx, int cury){
        if(i < 0 || i > grid.length || j < 0 || j > grid[0].length){
            return 0;
        }
        visited[i][j] = true;
        if(!visited[i][j]){
            if(i != curx){
                return Math.max(process_dfs(grid,i,j + 1,visited,res * grid[i][j],curx,cury),process_dfs(grid,i,j - 1,visited,res * grid[i][j],curx,cury));
            }else if(j != curx){
                return Math.max(process_dfs(grid,i + 1,j,visited,res * grid[i][j],curx,cury),process_dfs(grid,i - 1,j,visited,res * grid[i][j],curx,cury));
            }else if(i != curx && j != cury){
                return 0;
            }
        }
        int value = get(res);
        process_dfs(grid,i + 1,j,visited,res * grid[i][j],curx,cury);
        process_dfs(grid,i ,j+ 1,visited,res * grid[i][j],curx,cury);
        process_dfs(grid,i - 1,j,visited,res * grid[i][j],curx,cury);
        process_dfs(grid,i,j - 1,visited,res * grid[i][j],curx,cury);
        visited[i][j] = false;
        return value;
    }

    public static int get(int res){
        int ans = 0;
        while (res >= 0){
            if(res % 10 == 0){
                ans++;
                res /= 10;
            }else {
                break;
            }
        }
        return ans;
    }

}

class Solution {
    static int[][] c25 = new int[1001][2];

    static {
        // 预处理：递推算出每个数的因子 2 的个数和因子 5 的个数
        for (int i = 2; i <= 1000; i++) {
            if (i % 2 == 0) c25[i][0] = c25[i / 2][0] + 1;
            if (i % 5 == 0) c25[i][1] = c25[i / 5][1] + 1;
        }
    }

    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        int[][][] s = new int[m][n + 1][2];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                s[i][j + 1][0] = s[i][j][0] + c25[grid[i][j]][0]; // 每行的因子 2 的前缀和
                s[i][j + 1][1] = s[i][j][1] + c25[grid[i][j]][1]; // 每行的因子 5 的前缀和
            }

        for (int j = 0; j < n; j++) {
            for (int i = 0, s2 = 0, s5 = 0; i < m; i++) { // 从上往下，枚举左拐还是右拐
                s2 += c25[grid[i][j]][0];
                s5 += c25[grid[i][j]][1];
                ans = Math.max(ans, Math.max(Math.min(s2 + s[i][j][0], s5 + s[i][j][1]),
                        Math.min(s2 + s[i][n][0] - s[i][j + 1][0], s5 + s[i][n][1] - s[i][j + 1][1])));
            }
            for (int i = m - 1, s2 = 0, s5 = 0; i >= 0; i--) { // 从下往上，枚举左拐还是右拐
                s2 += c25[grid[i][j]][0];
                s5 += c25[grid[i][j]][1];
                ans = Math.max(ans, Math.max(Math.min(s2 + s[i][j][0], s5 + s[i][j][1]),
                        Math.min(s2 + s[i][n][0] - s[i][j + 1][0], s5 + s[i][n][1] - s[i][j + 1][1])));
            }
        }
        return ans;
    }
}

