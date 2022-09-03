package com.cn.Algorithm.array;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-03-17 23:50
 * @Description: tag ： 滑动窗口、前缀和、二分查找
 * @Project_name: java-learn
 */
public class minSubArrayLen_209 {

    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int ans = 0;
        int end = 0;
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += nums[i];
            while(sum >= target){
                ans = ans == 0 ? i -  end  + 1 : Math.min(ans, i -  end  + 1);
                sum -= nums[end++];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, test));
    }
}
