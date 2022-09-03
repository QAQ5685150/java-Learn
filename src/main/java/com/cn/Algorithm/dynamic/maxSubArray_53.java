package com.cn.Algorithm.dynamic;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-03-07 18:03
 * @Description: ����������
 * @Project_name: java-learn
 */
public class maxSubArray_53 {

    public static void main(String[] args) {
        int[] test = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(test));
    }


    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        int ans = 0;
        for (int i = 1; i < length; i++) {
            nums[i] += nums[i - 1] > 0 ? nums[i - 1] : 0;
            ans = Math.max(ans,nums[i]);
        }
        return ans;
    }
}
