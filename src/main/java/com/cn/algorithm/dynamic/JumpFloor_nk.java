package com.cn.algorithm.dynamic;

import java.util.HashMap;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-04-12 10:28
 * @Description: TODO
 * @Project_name: java-learn
 */
public class JumpFloor_nk {

    static HashMap<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(memory(4));
    }

    public static void test1() {

    }

    public static int memory(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int i = memory(n - 1) + memory(n - 2);
        cache.put(n,i);
        if(cache.get(n) != null){
            return cache.get(n);
        }
        return i;
    }
}
