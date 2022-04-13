package com.cn.algorithm.backpack;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/**
 * 类名: backpack0_1
 * 描述: TODO
 * 姓名: @author南风
 * 日期: 2021-12-30 9:54
 **/
public class backpack0_1 {

    public static void main(String[] args) {

//        int V = 5;
//        int N = 7;
//        int[] weight = new int[]{2,5,3,7,2,1,4};
//        int[] value = new int[]{1,2,3,1,4,1,2};
//
//        int[] test1 = new int[]{2,4,1};
//        int[] test2 = new int[]{10,5,4};
//        System.out.println("可装物品最大价值：" + backpack0_1(V,N,weight,value));
//        review01(V,N,weight,value);
//        System.out.println(PackAge(test1, test2, 5));
        //niuke_01();

        int[] arr = new int[]{2,4,2,1,0,100};
        int n = arr.length;
        int last = n - 1;
        int res = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (i + arr[i] >= last) {
                last = i;
                res += arr[i];
            }
        }

        if (last == 0) {
            System.out.println(res);
        } else {
            System.out.println(-1);
        }
    }

    public static void niuke_01(){
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(" ");
        int n = Integer.valueOf(s1[0]);
        int v = Integer.valueOf(s1[0]);
        int[] weight = new int[n];
        int[] values = new int[n];
        for(int i = 0;i < n;i++){
            String[] s = sc.nextLine().split(" ");
            weight[i] = Integer.valueOf(s[0]);
            values[i] = Integer.valueOf(s[1]);
        }

        int[][] dp = new int[n + 1][v + 1];
        int ans = 0;
        for(int i = 1;i < n + 1;i++){
            for(int j = 1;j < v + 1;j++){
                if(weight[i - 1] > j){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight[i - 1]] + values[i - 1]);
                }
                if(j == v){
                    ans = Math.max(ans,dp[i][j]);
                }
            }
        }
        System.out.println("=================");
        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("=================");
        System.out.println(dp[n][v]);
        System.out.println(ans);
    }

    public static int PackAge(int []weight,int []values,int amount)
    {
        int n=weight.length;
        int [][] dp = new int[weight.length][amount+1];

        for(int i=1;i<weight.length;i++)
        {

            for(int j=0;j<=amount;j++) {
                dp[i][0] = 0;
                dp[0][j] = 0;
                if ( j >= weight[i])
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+values[i]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println("=================");
        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("=================");
        return dp[n-1][amount];
    }

    public static void review(int V, int N, int[] weight, int[] value){
        int[][] dp = new int[V][N];
        for (int i = 0; i < V; i++) {
            for (int j = 1; j < N; j++) {
                if(weight[i - 1]  > j){
                    dp[i][j] = dp[i][j - 1];
                }else {
                    dp[i][j] = Math.max(dp[i][j - 1],dp[i][j - value[j]] + value[j]);
                }
            }
        }
    }

    public static void review01(int V, int N, int[] weight, int[] value){
        int[][] dp = new int[N + 1][V + 1];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                if(weight[i - 1]  > j){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        System.out.println(max);
    }

    /**
    *功能描述:0-1背包问题
    *@param V 背包总重量 题目的意思就是 在不超过物品总重量的情况下，找到能拿到最大value的值 对应weight[]数组
    *@param N 物品总数
    *@param weight 物品重量
    *@param value 物品价值
    *@return java.lang.Integer
    **/
    public static Integer backpack0_1(int V, int N, int[] weight, int[] value){
        int[][] dp = new int[N + 1][V + 1];
        int max = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if(weight[i - 1] > j){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
                max = Math.max(dp[i][j], max);
            }
            System.out.println();
        }
        System.out.println("=================");
        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("=================");
        return max;
    }
}
