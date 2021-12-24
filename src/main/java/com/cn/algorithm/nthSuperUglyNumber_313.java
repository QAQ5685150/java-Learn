package com.cn.algorithm;

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
    *功能描述:正确题解
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
}