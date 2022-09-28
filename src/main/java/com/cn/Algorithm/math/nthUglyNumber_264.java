package com.cn.Algorithm.math;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.math
 * @Time: 2022-09-28 13:26
 * @Description: TODO
 **/
public class nthUglyNumber_264 {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber_dp(8));
    }

    public static int nthUglyNumber(int n) {
        int[] arr = new int[]{2,3,5};
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        set.add(1L);
        int magic = 0;
        for (int i = 0; i < n; i++) {
            long tmp = pq.poll();
            magic = (int) tmp;
            for (int cur : arr) {
                long nn = tmp * cur;
                if(set.add(nn)){
                    pq.offer(nn);
                }
            }
        }
        return magic;
    }

    public static int nthUglyNumber_dp(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i = 1; i < n; i++) {
            int num1 = dp[i1] * 2;
            int num2 = dp[i2] * 3;
            int num3 = dp[i3] * 5;
            dp[i] = Math.min(num1,Math.min(num2,num3));
            if(dp[i] == num1) i1++;
            if(dp[i] == num2) i2++;
            if(dp[i] == num3) i3++;
        }
        return dp[n - 1];
    }
}
