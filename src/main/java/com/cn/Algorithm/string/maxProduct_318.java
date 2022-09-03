package com.cn.Algorithm.string;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 类名:maxProduct_318
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-17 11:17
 **/
public class maxProduct_318 {

    /**
     * 给你一个字符串数组words ，找出并返回 length(words[i]) * length(words[j])的最大值，
     * 并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。
    **/
    public static void main(String[] args) {
        String[] test = new String[]{"fcf","ce","cefde","dabae"};
        int i = maxProduct1(test);
        System.out.println(i);
    }

    public static int maxProduct(String[] words) {
        int len = words.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if(!isRepeat2(words[i],words[j])){
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    /**
    *功能描述:hash优化去重过程 948ms
    *@params1
    *@params2
    *@returnboolean
    **/
    public static boolean isRepeat2(String s1, String s2){
        int[] i1 = new int[26];
        int[] i2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            i1[s1.charAt(i) - 'a'] = 1;
        }
        for (int i = 0; i < s2.length(); i++) {
            i2[s2.charAt(i) - 'a'] = 1;
        }
        for(int i = 0;i < 26; i++){
            int j = i1[i] + i2[i];
            if(j > 1) return true;
        }
        return false;
    }

    /**
    *功能描述:set去重  超时
    *@params1
    *@params2
    *@returnboolean
    **/
    public static boolean isRepeat1(String s1, String s2){
        Set<Character> set1 = new HashSet<>();
        for (char c : s1.toCharArray()) {
            set1.add(c);
        }
        Set<Character> set2 = new HashSet<>();
        for (char c : s2.toCharArray()) {
            set2.add(c);
        }
        String s = "";
        Iterator<Character> iterator = set1.iterator();
        Iterator<Character> iterator1 = set2.iterator();
        while (iterator.hasNext()) s += iterator.next();
        while (iterator1.hasNext()) s += iterator1.next();
        Set<Character> set3 = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char o = s.charAt(i);
            if(!set3.contains(o)) set3.add(o);
            else return true;
        }
        return false;
    }



    /**
    *功能描述:位运算 去重
    *@param words
    *@return int
    **/
    public static int maxProduct1(String[] words) {
        int n = words.length;
        int[] wordBits = new int[n];
        for(int i = 0;i < n;i++){
            wordBits[i] = wordBit(words[i]);
        }
        int ans = 0;
        for(int i = 0;i < n;i++){
            for(int j = i + 1;j < n;j++){
                if((wordBits[i]&wordBits[j])!=0) continue;
                ans = Math.max(ans,words[i].length()*words[j].length());
            }
        }
        return ans;
    }

    private static int wordBit(String s){
        int n = s.length();
        int ans = 0;
        for(int i = 0;i < n;i++){
            int idx = s.charAt(i)-'a';
            ans |= 1<<idx;
        }
        return ans;
    }
}
