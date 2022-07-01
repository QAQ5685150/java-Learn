package com.cn.algorithm.window;

import java.util.Map;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.window
 * @Time: 2022-07-01 15:56
 **/
public class minSubArrayLen_209 {

    public static void main(String[] args) {

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int ans = 0;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target){
                ans = ans == 0 ?i - left + 1 : Math.min(ans,i - left + 1);
                sum -= nums[left++];
            }
        }
        return ans;
    }
}
