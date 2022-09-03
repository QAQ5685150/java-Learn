package com.cn.Algorithm.array;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-03-04 17:03
 * @Description: TODO
 * @Project_name: java-learn
 */
public class checkSubarraySum_523 {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3};
        System.out.println(checkSubarraySum(test, 5));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int[] arr = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            j += nums[i];
            arr[i] = j;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            if(tmp % k == 0){
                return true;
            }else {
                for (int l = i - 2; l >= 0; l--) {
                    if((arr[i] - arr[l]) % k == 0){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
