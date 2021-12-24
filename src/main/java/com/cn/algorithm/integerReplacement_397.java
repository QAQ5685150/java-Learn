package com.cn.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名:integerReplacement_397
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-19 16:49
 **/
public class integerReplacement_397 {

    private static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int test = 88888889;
        System.out.println(integerReplacement(test));
        long end = System.currentTimeMillis();
        System.out.println("program run " + (end - start) + " ms");
    }

    public static int integerReplacement(int n) {
        return (int)process((long)n);
    }

    private static long process(long n) {
        if(n ==1) return 0;
        if(n%2==0){
            return  1 + process(n/2);
        }else  {
            return 1 + Math.min(process(n+1),process(n-1));
        }
    }
}
