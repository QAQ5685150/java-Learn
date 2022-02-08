package com.cn.algorithm.sort.n2;

import com.cn.algorithm.util.printUtils;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-02-07 11:33
 * @Description: 选择排序
 * @Project_name: java-learn
 */
public class selectSort {

    public static int[] selectSort(int[] arr){
        int len = arr.length;
        if (arr == null || len < 2) {
            return null;
        }
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                minIndex = arr[j] > arr[minIndex] ? minIndex : j;
            }
            swap2(arr,minIndex,i);
        }
        return arr;
    }

    /**
     * 选择排序不能用异或交换位置，可能会产生0的结果，当前位置和自己异或就成0了
     */
    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void swap2(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] test = new int[]{9,4,6,5,1,3,2,7,6,4};
        printUtils.printArray(selectSort(test));
    }
}
