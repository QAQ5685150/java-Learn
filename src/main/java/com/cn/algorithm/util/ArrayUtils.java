package com.cn.algorithm.util;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-01-01 22:34
 * @Description: 数组图形化打印工具类
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
