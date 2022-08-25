package com.cn.algorithm.dynamic.gupiaomaimai;

/**
 * @Auther: @С�Ը����ɰ�
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
     * @param index  ��ǰ�ݹ�ָ��
     * @param len   ���鳤��
     * @param price   ��ǰ���ϵ�����
     * @param states  1��ʾ�����й�Ʊ  0��ʾ����û�й�Ʊ
     * @param prices  �۸�����
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
     * dfs�ݹ� -> dp��˼·
     * @param prices
     * @return
     */
    public static int maxProfit_dp(int[] prices){
        int len = prices.length;
        int[][] dp = new int[len + 1][2];
        //dp[i][0]�������й�Ʊ����ͬ��dfs(index + 1,len,price,0,prices)
        dp[0][0] = 0;
        //dp[i][1]������й�Ʊ����ͬ��dfs(index + 1,len,price,1,prices)
        //dp[0][1] = -prices[0]��ʾ��һ�������Ʊ��
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            //dp[i - 1][1] + prices[i] ��ʾ�ұ����й�Ʊ���ڽ���������״̬�ӣ��й�Ʊ -> û��Ʊ��
            //ÿ��ѭ�����ǡ�����һ�족 ����������Ʊ�൱��û�й�Ʊ�ˣ�������û�й�Ʊ��״̬��ѡһ������
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i],dp[i - 1][0]);
            //dp[i - 1][0] - prices[i] ��ʾ�����ϱ���û�й�Ʊ������ȥ������״̬�ӣ��� -> �У� ���Ǵ��������Ǯ��ȥ
            //��һλ�����൱������Ϊ�� ������dp[0][1] = -prices[0]
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i],dp[i - 1][1]);
        }
        return dp[len - 1][0];
    }
}
