package com.cn.Algorithm.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.array
 * @Time: 2022-10-08 13:42
 * @Description: TODO
 **/
public class advantageCount_890 {

    public static void main(String[] args) {

    }

    /**
     * 卡在最右边小于的地方怎么去，题解用下标数组排序的方式，不大于就从最右边拿最小值添上，田忌赛马
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount_my(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Arrays.sort(nums1);
        HashSet<Integer> set = new HashSet<>();
        int[] res = new int[len1];
        int index = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if(set.add(nums1[i]) && nums1[i] > nums2[j]){
                    res[index++] = nums1[i];
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 贪心 用下标数组排序，对数组下标取对应位置的值
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx = new Integer[n]; // nums2索引
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(nums1);
        Arrays.sort(idx, (i, j) -> nums2[i] - nums2[j]); //根据nums2数据升序，排序nums2(索引)
        int L = 0, R = n - 1; // nums2(索引)的左右指针
        for (int i : nums1) { // 遍历nums1
            if (i > nums2[idx[L]]) nums2[idx[L++]] = i; // 可以满足 nums1[i] > nums2[i]
            else nums2[idx[R--]] = i; //丢到数组最后
        }
        return nums2;
    }
}
