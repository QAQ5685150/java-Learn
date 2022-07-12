package com.cn.algorithm.dynamic;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-04-15 21:32
 * @Description: 动态规划 跳跃游戏系列
 * @Project_name: java-learn
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] test= new int[]{2,3,1,5,1,2,0,0,3,4};
        System.out.println(canJump1(test));

        int[] test2 = new int[]{2,3,0,1,4,3,3};
        System.out.println(canJump2(test2));
    }

    /**
     *跳跃游戏1
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     * @param nums
     * @return
     */
    public static boolean canJump1(int[] nums) {
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

    /**
     *跳跃游戏2
     * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 假设你总是可以到达数组的最后一个位置。
     * @param nums
     * @return
     */
    public static int canJump2(int[] nums) {
        int n = nums.length;
        int index = 0;
        int times = 0;
        for (int i = 0; i <= n - 1; i = index) {
            int max = 0;
            int rightmost = index + nums[i];
            while (i < n && i <= rightmost){
                i++;
                if(nums[i] >= max){
                    index = i;
                }
            }
            times++;
        }
        return times;
    }
    //官方题解
    public static int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int reach = 0;
        int nextreach = nums[0];
        int step = 0;
        for(int i = 0;i<nums.length;i++){
            nextreach = Math.max(i+nums[i],nextreach);
            if(nextreach >= nums.length-1) return (step+1);
            if(i == reach){
                step++;
                reach = nextreach;
            }
        }
        return step;
    }
}
