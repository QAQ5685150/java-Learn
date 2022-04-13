package com.cn.algorithm.array;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-04-08 16:21
 * @Description: TODO
 * @Project_name: java-learn
 */
public class maxSum_1537 {

    static int mod =1000000007;

    public static int maxSum(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0,j = 0;
        long sum1 = 0,sum2 = 0;
        long ans = 0;

        while (i < len1 && j < len2){
            if(nums1[i] < nums2[j]){
                sum1 += nums1[i];
                i++;
            }else if(nums1[i] > nums2[j]){
                sum2 += nums2[j];
                j++;
            }else {
                ans += Math.max(sum1,sum2);
                ans += nums1[i];
                i++;
                j++;
                sum1 = sum2 = 0;
            }
        }
        while (i < len1){
            sum1 += nums1[i++];
        }
        while (j < len2){
            sum2 += nums2[j++];
        }
        ans += Math.max(sum1,sum2);
        ans %= mod;
        return (int)ans;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{6,12,17,21,29,31};
        int[] test2 = new int[]{10,17,22,26,30,34};
        System.out.println(maxSum(test1, test2));
    }
}
