package com.cn.Algorithm.array;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-04-28 11:11
 * @Description: TODO
 * @Project_name: java-learn
 */
public class sortArrayByParity_905 {

    public static void main(String[] args) {
        int[] test = new int[]{0,2,1,3};
        System.out.println(sortArrayByParity(test));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        while(left < right){
            while(right > left && nums[left] % 2 != 0){
                swap(nums,left, right);
                right--;
            }
            left++;
        }
        return nums;
    }

    public static void swap(int[] nums,int x,int y){
        int tmp = nums[y];
        nums[y] = nums[x];
        nums[x] = tmp;
    }
}
