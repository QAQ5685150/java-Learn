package com.cn.algorithm.util;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-01-01 22:34
 * @Description: ����ͼ�λ���ӡ������
 * @Project_name: java-learn
 */
public class ArrayUtils {

    public static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void printArray(int[][] arr){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
