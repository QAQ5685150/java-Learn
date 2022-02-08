package com.cn.algorithm.sort.n2;

import com.cn.algorithm.util.printUtils;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-02-07 11:35
 * @Description: 插入排序
 * @Project_name: java-learn
 */
public class insertSort {

    public static int[] insertSort(int[] arr){
        int len = arr.length;
        if (arr == null || len < 2) {
            return null;
        }
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0 && arr[j] >= arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] test = new int[]{9,4,6,5,1,3,2,7,6,4};
        int[] ints = insertSort(test);
        printUtils.printArray(ints);
    }
}
