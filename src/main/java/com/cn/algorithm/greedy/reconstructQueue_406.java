package com.cn.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.greedy
 * @Time: 2022-07-15 16:52
 * @Description: TODO
 **/
public class reconstructQueue_406 {

    public static void main(String[] args) {

    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        return people;
    }
}
