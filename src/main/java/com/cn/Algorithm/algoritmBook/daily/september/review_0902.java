package com.cn.Algorithm.algoritmBook.daily.september;

import com.cn.Algorithm.util.printUtils;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.algoritmBook.september
 * @Time: 2022-09-02 10:37
 * @Description:
 *  ����0820�����⣬��������dfs����С���������˼·��dfsתdp��˼·
 **/
public class review_0902 {

    public static void main(String[] args) {
        review_0902 re = new review_0902();

        System.out.println(re.test01());
    }

    /**
     * ����0820 ������ �ϲ�����������С���ۣ�����leetcode��С����dp��
     *
     * @return
     */
    public int test01() {
        int[] test1 = new int[]{1,3,100,4,7};
        int[] test2 = new int[]{1,100,3,5};
        int i1 = process(test1, test2, 0, 0);
        //int dp = dp(test1, test2);
        return i1;
    }

    // 1,3,100,4  1,100,3,5
    public int process(int[] a, int[] b, int a1, int b1) {
        if (a1 == a.length && b1 == b.length) {
            return 0;
        }
        if (a1 == a.length && b1 != b.length) {
            return process(a, b, a1, b1 + 1);
        }
        if (a1 != a.length && b1 == b.length) {
            return process(a, b, a1 + 1, b1);
        }
        //������1 �� ɾ��a1
        int p1 = Math.abs(a[a1]) + process(a,b,a1 + 1, b1);
        //������2 �� ɾ��b1
        int p2 = Math.abs(b[b1]) + process(a,b,a1,b1 + 1);
        //������3 �� ��ɾ��
        int p3 = Math.abs(a[a1] - b[b1]) + process(a,b,a1 + 1, b1 + 1);
        return Math.min(p1,Math.min(p2,p3));
    }

    public int dp(int[] a, int[] b){
        int len1 = a.length;
        int len2 = b.length;
        int[][] dp = new int[len2 + 1][len1 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[0][i] = Math.abs(a[i - 1] - b[0]);
        }

        for (int i = 1; i <= len2; i++) {
            dp[i][0] = Math.abs(b[i - 1] - a[0]);
        }
        printUtils.printArray(dp);
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
               if(a[i - 1] == b[j - 1]){
                   dp[i][j] = dp[i - 1][j - 1];
               }else {
                   dp[i][j] = Math.min(dp[i - 1][j - 1],
                           Math.min(dp[i - 1][j],dp[i][j - 1]));
               }
            }
        }
        printUtils.printArray(dp);
        return dp[len1][len2];
    }
}
