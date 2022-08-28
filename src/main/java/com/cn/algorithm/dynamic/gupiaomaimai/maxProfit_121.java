package com.cn.algorithm.dynamic.gupiaomaimai;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-03-30 10:51
 * @Description: TODO
 * @Project_name: java-learn
 */
public class maxProfit_121 {

    public static void main(String[] args) {
        int[] test = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit_review(test));
        System.out.println(maxProfit_dp(test));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < len; i++) {
            max = prices[i];
            min = Math.min(min,prices[i]);
            res = Math.max(res,max - min);
        }
        return res;
    }

    public static int maxProfit_review(int[] prices) {
        int len = prices.length;
        int res = prices[0];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int cur = prices[i];
            min = Math.min(min,prices[i]);
            res = Math.max(res,cur - min);
        }
        return res;
    }

    public static int maxProfit_dp(int[] prices) {
        int len = prices.length;
        int[][] profit = new int[len][2];
        profit[0][1] = -prices[0];
        for(int i = 1; i < len; i++){
            profit[i][0] = Math.max(profit[i - 1][1] + prices[i], profit[i - 1][0]);
            profit[i][1] = Math.max( -prices[i], profit[i - 1][1]);
        }
        return profit[len - 1][0];
    }
}
