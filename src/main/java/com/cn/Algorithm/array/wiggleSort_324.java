package com.cn.Algorithm.array;

import java.util.Arrays;

public class wiggleSort_324 {

    /**
     * 324. �ڶ����� II
     * @param args
     */
    public static void main(String[] args) {
        int[] test = new int[]{1,3,4,2,3,5,4,6,5,7,6};
        wiggleSort2(test);
    }

    /**
     * �����ص��뷨�������Ժ�˫ָ��ͷβ������ӵ��µ�����
     * ����������ظ����������
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
     * ��ȷ�����
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
