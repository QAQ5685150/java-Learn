package com.cn.Algorithm.array;

import java.util.HashMap;

/**
 * 类名: subarraySum_560
 * 描述: TODO
 * 姓名: @author南风
 * 日期: 2022-02-18 17:22
 **/
public class subarraySum_560 {

    public static void main(String[] args) {
        int[] test = new int[]{1,1,1};
        System.out.println(subarraySum_hash(test,2));

    }

    public static int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int target = 0;
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < i; j++) {
                if(sum[i] - sum[j] == k) target++;
            }
        }
        return target;
    }

    public static int subarraySum_hash(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int res = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if(map.containsKey(pre - k))
                res += map.get(pre - k);
            map.put(pre,map.getOrDefault(pre,0) + 1);
        }
        return res;
    }
}
