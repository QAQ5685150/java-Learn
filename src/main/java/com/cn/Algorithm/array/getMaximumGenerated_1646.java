package com.cn.Algorithm.array;

/**
 * 类名:getMaximumGenerated_1646
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-23 15:04
 **/
public class getMaximumGenerated_1646 {

    /**
     * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
     *
     * nums[0] = 0
     * nums[1] = 1
     * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
     * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
     * 返回生成数组 nums 中的 最大值。
    **/
    public static void main(String[] args) {
        getMaximumGenerated(7);

    }

    public static int getMaximumGenerated(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 0;nums[1] = 1;
        int res = 0;

        for(int i = 2;i <= n;i++){
            if(i % 2 == 0){
                nums[i] = nums[i / 2];
            }else{
                nums[i] = nums[i / 2] + nums[(i + 1) / 2];
            }
            res = Math.max(res,nums[i]);
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
        return res;
    }
}
