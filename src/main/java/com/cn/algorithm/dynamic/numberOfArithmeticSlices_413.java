package com.cn.algorithm.dynamic;

/**
 * 类名:numberOfArithmeticSlices_413
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-10 9:57
 **/
public class numberOfArithmeticSlices_413 {

    /**
    *功能描述: 差分数组，辅助数组dp保存当前位置 i 有多少等差数列存在，每多一个相等的，数组累加 +1当前位置的前缀和
     * 例如 1，2，3，4，7，8，9   1，2，3，4 组成一个等差数列，(nums[0] - nums[1]) == (nums[1] - nums[2])判断1，2，3，4
     * 1，2，3 是一个  下一个2，3，4判断还相等，说明1，2，3，4是一组，就在dp[i-1]位置+1 累加后1，2，3，4算3个，以此类推
    **/
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

    /**
    *功能描述:动态规划
    *@param nums
    *@return int
    **/
    public static int numberOfArithmeticSlices1(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int d = nums[0] - nums[1], t = 0;
        int ans = 0;
        // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
        for (int i = 2; i < n; ++i) {
            if (nums[i - 1] - nums[i] == d) {
                ++t;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }

    /**
     * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
     *
     * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
     * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
     *
     * 子数组 是数组中的一个连续序列。
    **/
    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5};
        System.out.println(numberOfArithmeticSlices(test));
        System.out.println(numberOfArithmeticSlices1(test));
    }
}
