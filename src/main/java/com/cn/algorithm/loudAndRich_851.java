package com.cn.algorithm;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 类名: loudAndRich_851
 * 描述: TODO
 * 姓名: @author南风
 * 日期: 2021-12-16 16:28
 **/
public class loudAndRich_851 {

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = new int[]{3,2,5,4,6,1,7,0};
        int[] ints = loudAndRich(test, quiet);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    public static int[] loudAndRich(int[][] richer, int[] quiet){
        int n = quiet.length;
        int[] res = Arrays.copyOf(quiet, n);
        boolean flag = true;  // 是否交换
        while(flag){
            flag = false;
            for(int[] r:richer){
                if(res[r[0]] < res[r[1]]){
                    res[r[1]] = res[r[0]];
                    flag = true;
                }
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(quiet[i], i);
        }
        for(int i=0;i<n;i++){
            res[i] = map.get(res[i]);
        }
        return res;
    }
}
