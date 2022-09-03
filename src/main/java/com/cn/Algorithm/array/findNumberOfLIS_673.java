package com.cn.Algorithm.array;

import java.util.Arrays;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-04-18 11:34
 * @Description: TODO
 * @Project_name: java-learn
 */
public class findNumberOfLIS_673 {

    public static void main(String[] args) {
        int[] test = new int[]{5,1,2,3,4,1,2,9,6,7};
        int[] indexOfLIS = findIndexOfLIS(test);
        for (int indexOfLI : indexOfLIS) {
            System.out.print(indexOfLI + " ");
        }
    }

    public static int[] findIndexOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 0;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]){
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
            if(dp[i] > max){
                index = i;
                max = dp[i];
            }
        }
        int[] res = new int[max];
        for (int i = max - 1; i >= 0 ; i--) {
            res[i] = nums[index--];
        }
        return res;
    }
}
