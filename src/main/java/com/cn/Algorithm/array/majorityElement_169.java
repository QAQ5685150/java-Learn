package com.cn.Algorithm.array;

import java.util.HashMap;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.array
 * @Time: 2022-07-06 11:07
 **/
public class majorityElement_169 {

    public static void main(String[] args) {

    }

    public static int majorityElement(int[] nums) {
        int len = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        final int[] max = {0};
        map.forEach((k,v) -> {
            if(v > len / 2){
                max[0] = k;
            }
        });
        return max[0];
    }
}
