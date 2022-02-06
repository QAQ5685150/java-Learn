package com.cn.algorithm.array;

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
        int k = inputUtils.getInt();
        int w = inputUtils.getInt();
        int[] profits = inputUtils.getArr();
        int[] capital = inputUtils.getArr();
        int maximizedCapital = findMaximizedCapital(k, w, profits, capital);
        System.out.println(maximizedCapital);
    }

}
