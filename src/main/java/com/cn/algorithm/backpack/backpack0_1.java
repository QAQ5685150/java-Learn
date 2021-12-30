package com.cn.algorithm.backpack;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * 类名: backpack0_1
 * 描述: TODO
 * 姓名: @author南风
 * 日期: 2021-12-30 9:54
 **/
public class backpack0_1 {

    public static void main(String[] args) {
        int V = 5;
        int N = 7;
        int[] weight = new int[]{2,5,3,7,2,1,4};
        int[] value = new int[]{1,2,3,1,4,1,2};
        System.out.println("可装物品最大重量：" + backpack0_1(V,N,weight,value));
    }

    /**
    *功能描述:0-1背包问题
    *@param V 背包容量
    *@param N 物品总数
    *@param weight 物品重量
    *@param value 物品价值
    *@return java.lang.Integer
    **/
    public static Integer backpack0_1(int V, int N, int[] weight, int[] value){
        int[][] dp = new int[V + 1][N + 1];
        int max = 0;
        for (int i = 1; i < V + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if(weight[i - 1] > j){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
                max = Math.max(dp[i][j], max);
                if(j != N + 1){
                    System.out.print(dp[i][j] + " ");
                }
                else System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return max;
    }





}
