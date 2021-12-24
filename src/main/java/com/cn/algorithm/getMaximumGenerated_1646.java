package com.cn.algorithm;

/**
 * 类名:getMaximumGenerated_1646
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-23 15:04
 **/
public class getMaximumGenerated_1646 {

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
