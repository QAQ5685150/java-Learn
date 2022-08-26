package com.cn.algorithm.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-01-01 22:34
 * @Description: ��ӡ������
 * @Project_name: java-learn
 */
public class printUtils {

    /**
     * int[]�����ӡ
     * @param arr
     */
    public static void printArray(int[] arr){
        System.out.println();
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * List<>��ӡ
     * @param list
     * @param <T>
     */
    public static<T> void printArray(List<T> list){
        System.out.println();
        for (T t : list) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    /**
     * ��ά�����ӡ
     * @param arr
     */
    public static void printArray(int[][] arr){
        System.out.println();
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    /**
     * Map��ӡ
     * @param map
     * @param <K>
     * @param <V>
     */
    public static<K,V> void printMap(Map<K,V> map){
        System.out.println();
        Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<K, V> next = iterator.next();
            System.out.println(next.getKey() + " : " + next.getValue());
        }
    }
}
