package com.cn.algorithm;

/**
 * 类名:numberOfArithmeticSlices_413
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-10 9:57
 **/
public class numberOfArithmeticSlices_413 {

    public static int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        int sum = 0;
        if(len < 3){
            return 0;
        }
        int[] dp = new int[len];
        if((nums[0] - nums[1]) == (nums[1] - nums[2])){
            dp[2] = 1;
        }
        sum += dp[2];
        for(int i = 3;i < len;i++){
            if((nums[i-2] - nums[i-1]) == (nums[i-1] - nums[i])){
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5,6,7};
        System.out.println(numberOfArithmeticSlices(test));
    }
}
