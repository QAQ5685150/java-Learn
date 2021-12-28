package com.cn.algorithm.dfs;

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


    private static Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    /**
     * 给定一个正整数n ，你可以做如下操作：
     * 如果n是偶数，则用n / 2替换n 。
     * 如果n是奇数，则可以用n + 1或n - 1替换n 。
     * n变为 1 所需的最小替换次数是多少？
     **/
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int test = 88888889;
        System.out.println(integerReplacement(test));
        long end = System.currentTimeMillis();
        System.out.println("program run " + (end - start) + " ms");
    }

    public static int integerReplacement(int n) {
        return (int) process((long) n);
    }

    private static long process(long n) {
        if (n == 1) return 0;
        if (n % 2 == 0) {
            return 1 + process(n / 2);
        } else {
            return 1 + Math.min(process(n + 1), process(n - 1));
        }
    }

    /**
    *功能描述:记忆化搜索
    *@param n
    *@return int
    **/
    public static int integerReplacement1(int n) {
        if (n == 1) {
            return 0;
        }
        if (!memo.containsKey(n)) {
            if (n % 2 == 0) {
                memo.put(n, 1 + integerReplacement(n / 2));
            } else {
                memo.put(n, 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)));
            }
        }
        return memo.get(n);
    }
}
