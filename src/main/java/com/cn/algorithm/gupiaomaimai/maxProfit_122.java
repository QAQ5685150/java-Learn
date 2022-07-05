package com.cn.algorithm.gupiaomaimai;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-03-31 20:11
 * @Description: TODO
 * @Project_name: java-learn
 */
public class maxProfit_122 {
    static int res = 0;

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5};
        //System.out.println(maxProfit_dfs(test));
        System.out.println(maxProfit_dp(test));
    }

    public static int maxProfit_dfs(int[] prices) {
        dfs(0,prices.length,0,0,prices);
        return res;
    }

    /**
     *
     * @param index  当前递归指针
     * @param len   数组长度
     * @param price   当前手上的利润
     * @param states  1表示手上有股票  0表示手上没有股票
     * @param prices  价格数组
     * @return
     */
    public static void dfs(int index,int len,int price,int states,int[] prices){
        if(index == len - 1){
            res = Math.max(res,price);
            return ;
        }

        dfs(index+1,len,price,states,prices);

        if(states == 1){
            dfs(index+1,len,price + prices[index],0,prices);
        }else {
            dfs(index+1,len,price - prices[index],1,prices);
        }
    }


    /**
     * dfs递归 -> dp的思路
     * @param prices
     * @return
     */
    public static int maxProfit_dp(int[] prices){
        int len = prices.length;
        int[][] dp = new int[len + 1][2];
        //dp[i][0]代表不持有股票，等同于dfs(index + 1,len,price,0,prices)
        dp[0][0] = 0;
        //dp[i][1]代表持有股票，等同于dfs(index + 1,len,price,1,prices)
        //dp[0][1] = -prices[0]表示第一手买入股票，
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            //dp[i - 1][1] + prices[i] 表示我本来有股票，在今天卖出，状态从（有股票 -> 没股票）
            //每次循环就是“过了一天” 今天卖出股票相当于没有股票了，和昨天没有股票的状态比选一个最大的
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i],dp[i - 1][0]);
            //dp[i - 1][0] - prices[i] 表示我手上本来没有股票，现在去卖出，状态从（无 -> 有） 就是从收益里扣钱出去
            //在一位置买相当于收益为负 所以是dp[0][1] = -prices[0]
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i],dp[i - 1][1]);
        }
        return dp[len - 1][0];
    }
}
