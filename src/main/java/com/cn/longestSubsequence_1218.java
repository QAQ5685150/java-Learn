package com.cn;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 类名:longestSubsequence_1218
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-05 17:58
 **/
public class longestSubsequence_1218 {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4};
        int dif = 1;
        System.out.println(longestSubsequence(test, dif));
    }

    public static int longestSubsequence(int[] arr, int difference) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length; i++){
            int num = 0;
            int cur = arr[i] + difference;
            while (!set.contains(cur)){
                cur = cur + difference;
                num++;
            }
            max = Math.max(max,num);
        }
        return max;
    }
}
