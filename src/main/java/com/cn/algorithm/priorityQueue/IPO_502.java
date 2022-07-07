package com.cn.algorithm.priorityQueue;

import com.cn.algorithm.util.inputUtils;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-02-06 23:11
 * @Description: TODO
 * @Project_name: java-learn
 */
public class IPO_502 {

    /**
     * 给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。
     *
     * 最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
     *
     * 总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。
     */
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length;
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr,(a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> y - x);
        int index = 0;
        int ans = 0;
        for (int i = 0; i < k; i++) {
            while (index < len && arr[index][0] <= w){
                pq.add(arr[index][1]);
                index++;
            }
            if(!pq.isEmpty()){
                w += pq.poll();
            }else {
                break;
            }
        }
        return w;
    }

    public static void main(String[] args) {
//        int k = inputUtils.getInt();
//        int w = inputUtils.getInt();
//        int[] profits = inputUtils.getArr();
//        int[] capital = inputUtils.getArr();
        int maximizedCapital = findMaximizedCapital_review(2, 0, new int[]{1,2,3},new int[]{0,1,1});
        System.out.println(maximizedCapital);
    }


    public static int findMaximizedCapital_review(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>( (a,b) -> {
            return b[0] - a[0];
        });

        int[][] collection = new int[profits.length][2];
        for (int i = 0; i < profits.length; i++) {
            collection[i][0] = profits[i];
            collection[i][1] = capital[i];
        }
        //要对资本进行排序 从小到大
        Arrays.sort(collection,(a,b) -> a[1] - b[1]);
        //用index表示数组下标索引，用k表示每一次循环的次数（k在题中是能同时参与的最多个项目）
        //i循环多少次就是参与了多少个项目，因为每次循环里面的while会把所有符合的项目加入pq,利用堆的特性取出每一轮最大的利润
        //取出来i次，所以是对i<k循环
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (index < profits.length && collection[index][1] <= w){
                pq.add(collection[index++]);
            }
            if(!pq.isEmpty()){
                w += pq.poll()[0];
            }else {
                break;
            }
        }
        return w;
    }

}
