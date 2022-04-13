package com.cn.algorithm.array;

import java.util.Arrays;

/**
 * @Auther: @Ğ¡ÄÔ¸«²»¿É°®
 * @Time: 2022-04-10 20:09
 * @Description: TODO
 * @Project_name: java-learn
 */
public class nextPermutation_31 {

    public static void main(String[] args) {
        int[] test = new int[]{4,2,0,2,3,2,0};
        nextPermutation(test);
    }

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int first = 0,second = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j]){
                    first = j;
                    second = i;
                    break;
                }
            }
            if (first != 0 || second != 0) break;
        }
        swap(nums,first,second);

        if(first == 0 && second == 0){
            Arrays.sort(nums);
        }

        for (int i = first + 1; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if(nums[i] > nums[j]){
                    swap(nums,i,j);
                }
            }
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void swap(int[] nums, int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
