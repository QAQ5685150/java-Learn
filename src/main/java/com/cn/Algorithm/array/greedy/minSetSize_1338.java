package com.cn.Algorithm.array.greedy;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.array.greedy
 * @Time: 2022-08-29 14:48
 * @Description: 1338. 数组大小减半
 **/
public class minSetSize_1338 {

    public static void main(String[] args) {
        int[] test = new int[]{3,3,3,3,5,5,5,2,2,7};
        System.out.println(minSetSize(test));
    }

    public static int minSetSize(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> b[1] - a[1] );
        map.forEach( (k,v) -> {
            pq.add(new int[]{k,v});
        });
        int res = 0;
        int index = 0;
        while (!pq.isEmpty()){
            int[] poll = pq.poll();
            res += poll[1];
            index++;
            if(res >= arr.length / 2) {
                return index;
            }
        }
        return -1;
    }
}
