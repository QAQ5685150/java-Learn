package com.cn.algorithm.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-01-01 22:34
 * @Description: 打印工具类
 * @Project_name: java-learn
 */
public class printUtils {

    /**
     * int[]数组打印
     * @param arr
     */
    public static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * List<>打印
     * @param list
     * @param <T>
     */
    public static<T> void printArray(List<T> list){
        for (T t : list) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    /**
     * 二维数组打印
     * @param arr
     */
    public static void printArray(int[][] arr){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    /**
     * Map打印
     * @param map
     * @param <K>
     * @param <V>
     */
    public static<K,V> void printMap(Map<K,V> map){
        Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<K, V> next = iterator.next();
            System.out.println(next.getKey() + " : " + next.getValue());
        }
    }
}
