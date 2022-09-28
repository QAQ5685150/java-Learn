package com.cn.Algorithm.math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.math
 * @Time: 2022-09-28 10:12
 * @Description: TODO
 **/
public class getKthMagicNumber_17_09 {
//1 3 5 7 9 15 21 25 27
    public static void main(String[] args) {
        System.out.println(getKthMagicNumber_dp(8));
    }

    public static int getKthMagicNumber_1(int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(7);
        pq.add(9);
        int[] arr = new int[k * 2];
        arr[0] = 1;arr[1] = 3;
        int index = 2;
        for(int i = 3; i < k * 2; i++){
            Integer tmp = pq.poll();
            arr[index++] = tmp;
            pq.add(tmp * 3);
            pq.add(tmp * 5);
            pq.add(tmp * 7);
        }
        return arr[k];
    }

    /**
     * 利用set去重(计算过程中pq可能出现重复数 3*5 5*3 计算了两遍)
     *  pq最小堆保存当前算到的第一个数()
     * @param k
     * @return
     */
    public static int getKthMagicNumber(int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int[] arr = new int[]{3,5,7};
        Set<Long> set = new HashSet<>();
        pq.offer(1L);
        set.add(1L);
        int magic = 0;
        for (int i = 0; i < k; i++) {
            long tmp = pq.poll();
            magic = (int) tmp;
            for (int j : arr) {
                long cur = j * tmp;
                if(set.add(cur)){
                    pq.offer(cur);
                }
            }
        }
        return magic;
    }

    public static int getKthMagicNumber_dp(int k) {
        int[] dp = new int[k + 1];
        dp[0] = 1;
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i = 1; i <= k; i++) {
            int num3 = dp[i1] * 3;
            int num5 = dp[i2] * 5;
            int num7 = dp[i3] * 7;
            dp[i] = Math.min(num3,Math.min(num5, num7));
            if(dp[i] == num3){
                i1++;
            }
            if(dp[i] == num5){
                i2++;
            }
            if(dp[i] == num7){
                i3++;
            }
        }
        return dp[k - 1];
    }
}
