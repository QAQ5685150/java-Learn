package com.cn.Algorithm.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 小脑斧不可爱
 * @Time: 2022-01-01 22:34
 * @Description: TODO
 * @Project_name: java-learn
 */
public class printUtils {

    public static void printArray(int[] arr){
        System.out.println();
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static<T> void printArray(List<T> list){
        System.out.println();
        for (T t : list) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static void printArray(int[][] arr){
        System.out.println();
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static<K,V> void printMap(Map<K,V> map){
        System.out.println();
        Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<K, V> next = iterator.next();
            System.out.println(next.getKey() + " : " + next.getValue());
        }
    }
}
