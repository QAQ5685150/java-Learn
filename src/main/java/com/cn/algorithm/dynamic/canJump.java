package com.cn.algorithm.dynamic;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-04-15 21:32
 * @Description: TODO
 * @Project_name: java-learn
 */
public class canJump {

    public static void main(String[] args) {
        int[] test= new int[]{2,3,1,5,1,2,0,0,3,4};
        canJump(test);
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;//维护一个最远能跳到的距离，当这个距离大于数组长度，说明能跳到最后（题没读懂，我以为要正好到最后一个位置）
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
