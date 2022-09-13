package com.cn.Algorithm.algoritmBook.niuke;

import java.util.*;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.algoritmBook.niuke
 * @Time: 2022-09-13 14:50
 * @Description: DP13 [NOIP2002 普及组] 过河卒
 **/
public class DP13 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        //System.out.println(process(1,1,n,m,x,y));
        dp(n,m,x,y);
    }

//     public static int process(int n,int m,int x,int y,int m1,int m2){
//         if(n > x || m > y){
//             return 0;
//         }
//         if((n == x || m == y) || Math.abs(n - m1) + Math.abs(m - m2) != 3 && n != m1 && m != m2){
//             return 1;
//         }
// //         if(Math.abs(n - m1) + Math.abs(m - m2) == 3){
// //             return 1;
// //         }
//         return process(n + 1, m, x, y, m1 ,m2) + process(n, m + 1, x, y, m1 ,m2);
//     }

    public static void dp(int n, int m, int x, int y){
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 1;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if((i == j && i ==0) || (x == i && y == j) || Math.abs(i - x) + Math.abs(j - y) == 3 && i != x && j != y){
                    continue;
                }
                if(i == 0){
                    dp[i][j] = dp[i][j - 1];
                }else if(j == 0){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
