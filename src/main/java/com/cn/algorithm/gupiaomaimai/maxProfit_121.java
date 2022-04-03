package com.cn.algorithm.gupiaomaimai;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-03-30 10:51
 * @Description: TODO
 * @Project_name: java-learn
 */
public class maxProfit_121 {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5};
        System.out.println(maxProfit(test));
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
}
