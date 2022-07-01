package com.cn.algorithm.array;

import java.util.Arrays;

public class wiggleSort_324 {

    /**
     * 324. 摆动排序 II
     * @param args
     */
    public static void main(String[] args) {
        int[] test = new int[]{1,3,4,2,3,5,4,6,5,7,6};
        wiggleSort2(test);
    }

    /**
     * 最朴素的想法，排序以后双指针头尾向内添加到新的数组
     * 如果数组有重复会出现问题
     * @param nums
     */
        public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length - 1;
        int i = 0;
        int[] arr = new int[nums.length];
        int index = 0;
        while (i < len){
            arr[index++] = nums[i++];
            arr[index++] = nums[len--];
        }
        if(nums.length % 2 != 0){
            arr[index] = nums[i++];
        }
        nums = arr;
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 正确答案题解
     * @param nums
     */
    public static void wiggleSort2(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
