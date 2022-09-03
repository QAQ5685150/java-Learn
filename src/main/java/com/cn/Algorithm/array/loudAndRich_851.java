package com.cn.Algorithm.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 类名: loudAndRich_851
 * 描述: TODO
 * 姓名: @author南风
 * 日期: 2021-12-16 16:28
 **/
public class loudAndRich_851 {

    //寻找比当前这个人 更有钱 的人里 最低调 的。
    /**
    *有一组 n 个人作为实验对象，从 0 到 n - 1 编号，其中每个人都有不同数目的钱，以及不同程度的安静值（quietness）。
     * 为了方便起见，我们将编号为x的人简称为 "personx"。
     *
     * 给你一个数组 richer ，其中 richer[i] = [ai, bi] 表示 personai比 personbi更有钱。
     * 另给你一个整数数组 quiet ，其中quiet[i] 是 person i 的安静值。richer 中所给出的数据 逻辑自洽（也就是说，在 person x 比 person y 更有钱的同时，不会出现 person y 比 person x 更有钱的情况 ）。
     *
     * 现在，返回一个整数数组 answer 作为答案，其中answer[x] = y的前提是，
     * 在所有拥有的钱肯定不少于personx的人中，persony是最安静的人（也就是安静值quiet[y]最小的人）。
    **/
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
