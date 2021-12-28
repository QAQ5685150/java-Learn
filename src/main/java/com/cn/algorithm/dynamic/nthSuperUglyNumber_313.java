package com.cn.algorithm.dynamic;

import java.util.PriorityQueue;

/**
 * 类名:nthSuperUglyNumber_313
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-18 15:20
 **/
public class nthSuperUglyNumber_313 {

    public static void main(String[] args) {
        int[] test = new int[]{2,7,13,19};
        int num = 12;
        System.out.println(nthSuperUglyNumber(num, test));
    }

    /**
    *功能描述:313错误示范
    *@paramn
    *@param primes
    *@return int
    **/
    public static int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int[] res = new int[n+1];
        res[0] = 1;
        for(int i = 1;i < n;i++){
            for (int prime : primes) {
                heap.add(prime * res[i - 1]);
            }
            res[i] = heap.poll();
            while (!heap.isEmpty() && res[i] == heap.peek()){
                heap.poll();
            }
        }
        return res[n - 1];
    }


    /**
    *功能描述:堆的解题方法
    *@paramn
    *@param primes
    *@return int
    **/
     public static int nthSuperUglyNumber_right(int n, int[] primes) {
       PriorityQueue<Long>queue=new PriorityQueue<>();
         long res=1;
         for(int i=1;i<n;i++){
             for(int prime:primes){ //遍历primes里的数和当前最小的结果相乘加入堆
                 queue.add(prime*res);
             }
             res=queue.poll();
             while(!queue.isEmpty()&&res==queue.peek()) queue.poll();//每次弹出堆上最小的那个 堆用作保存结果集
         }
         return (int)res;
     }

     /**
     *功能描述:动态规划
     *@param n
     *@param primes
     *@return int
     **/
    public static int nthSuperUglyNumber_right1(int n, int[] primes) {
        int m = primes.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<m;i++)
            pq.add(new int[]{primes[i], 0, i});
        int[] dp = new int[n];
        dp[0] = 1;

        for(int i=1;i<n;){
            int[] tmp = pq.poll();
            // 丑数，下一个该乘的丑数，质因数
            int val = tmp[0], idx = tmp[1] + 1, p = tmp[2];
            if(val!=dp[i-1]) dp[i++] = val;
            pq.add(new int[]{dp[idx] * primes[p], idx, p});
        }
        return dp[n-1];
    }
}