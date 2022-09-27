package com.cn.Algorithm.dynamic;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.dynamic
 * @Time: 2022-08-23 15:35
 * @Description: TODO
 **/
public class minDistance_72 {

    public static void main(String[] args) {
        System.out.println(minDistance("horse","ros"));
        System.out.println(minDistance_recursion("horse","ros",0,0));
        System.out.println(minDistance_recursion1("horse","ros"));
    }

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len2 + 1][len1 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len2; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len2; i++) {
            for (int j = 1; j <= len1; j++) {
                char c1 = word1.charAt(j - 1);
                char c2 = word2.charAt(i - 1);
                int left = dp[i][j-1] + 1;
                int down = dp[i-1][j] + 1;
                int left_down = dp[i-1][j-1] + 1;
                if(c1 != c2) left_down += 1;
                dp[i][j] = Math.min(left,Math.min(down,left_down));
            }
        }
        return dp[len2][len1];
    }

    public static int minDistance_recursion(String word1, String word2, int i, int j){
        if(i == word1.length() || j == word2.length()){
            return word1.length() - i + word2.length() - j;
        }
        int res = 0;
        if(word1.charAt(i) == word2.charAt(j)) minDistance_recursion(word1,word2,i + 1, j + 1);
        int left = minDistance_recursion(word1,word2,i + 1, j) + 1;
        int up = minDistance_recursion(word1,word2,i,j + 1) + 1;
        int left_up = minDistance_recursion(word1,word2,i + 1, j + 1) + 1;

        return res + Math.min(left,Math.min(up,left_up));
    }

    public static int minDistance_recursion1(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        return helper(new HashMap<Pair,Integer>(), 0, 0, c1, c2);
    }
    //cache为缓存，i是指向Word1的下标，j指向word2下标，c1是word1，c2是word2
    private static int helper(HashMap<Pair,Integer> cache, int i, int j, char[] c1, char[] c2) {
        Pair p = new Pair(i, j);
        if(cache.containsKey(p)) {
            return cache.get(p);
        }
        //假设i走到头了，j没有，那么word1要变换成word2需要len(c2)-j步操作
        //同理，j走到头了，i没有，那么需要len(c1)-i步，下面判断是将这两个边界情况合并了
        if(i == c1.length || j == c2.length) {
            return c1.length - i + c2.length - j;
        }
        //如果两个字符相等
        if(c1[i] == c2[j]) {
            cache.put(p,helper(cache, i + 1, j + 1, c1, c2));
        }
        //如果两个字符不等，需要删除、增加、替换操作，对应a、b、c
        //最后取三者较小者即可
        else {
            int a = helper(cache, i + 1, j, c1, c2) + 1;
            int b = helper(cache, i, j + 1, c1, c2) + 1;
            int c = helper(cache, i + 1, j + 1, c1, c2) + 1;
            cache.put(p, Math.min(a, Math.min(b,c)));
        }
        return cache.get(p);
    }
}
