package com.cn.Algorithm.array.greedy;

import java.util.Arrays;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.array.greedy
 * @Time: 2022-08-29 14:18
 * @Description: 135. ·Ö·¢ÌÇ¹û
 **/
public class candy_135 {

    public static void main(String[] args) {
        int[] test = new int[]{1,0,2};
        System.out.println(candy(test));
    }

    public static int candy(int[] ratings){
        int res = 0;
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for (int i = 1; i < len; i++) {
            if(ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = len - 1; i > 0; i--) {
            if(ratings[i] < ratings[i - 1]){
                right[i - 1] = right[i] + 1;
            }
        }
        for (int i = 0; i < len; i++) {
            res += Math.max(left[i],right[i]);
        }
        return res;
    }
}
