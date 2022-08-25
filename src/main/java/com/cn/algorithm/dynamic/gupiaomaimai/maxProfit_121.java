package com.cn.algorithm.dynamic.gupiaomaimai;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-03-30 10:51
 * @Description: TODO
 * @Project_name: java-learn
 */
public class maxProfit_121 {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5};
        System.out.println(maxProfit_review(test));
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
}
