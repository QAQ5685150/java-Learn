package com.cn.algorithm.sort.n2;

import com.cn.algorithm.util.printUtils;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-02-07 11:33
 * @Description: ѡ������
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
     * ѡ������������򽻻�λ�ã����ܻ����0�Ľ������ǰλ�ú��Լ����ͳ�0��
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
