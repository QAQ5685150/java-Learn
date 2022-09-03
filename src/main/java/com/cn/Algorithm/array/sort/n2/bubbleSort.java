package com.cn.Algorithm.array.sort.n2;

import com.cn.Algorithm.util.printUtils;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-02-07 11:32
 * @Description: Ã°ÅÝÅÅÐò
 * @Project_name: java-learn
 */
public class bubbleSort {

    public static int[] bubbleSort(int[] arr){
        int len = arr.length;
        if (arr == null || len < 2) {
            return null;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if(arr[i] >= arr[j]){
                    swap(arr,i,j);
                }
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
        int[] ints = bubbleSort(test);
        printUtils.printArray(ints);
    }
}
