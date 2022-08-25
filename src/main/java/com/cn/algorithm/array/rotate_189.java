package com.cn.algorithm.array;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.array
 * @Time: 2022-08-23 14:24
 * @Description: 189. ÂÖ×ªÊý×é
 **/
public class rotate_189 {

    public static void main(String[] args) {

    }

    public static void rotate1(int[] nums, int k) {
        int len = nums.length - 1;
        if(len <= k) k = k % nums.length;
        reverseRange(nums,len - k + 1, len);
        reverseRange(nums,0,len - k);
        reverseRange(nums,0,len);
    }

    public static void reverseRange(int[] nums,int i, int j){
        while(i < j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
