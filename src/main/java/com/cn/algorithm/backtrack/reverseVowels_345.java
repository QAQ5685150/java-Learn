package com.cn.algorithm.backtrack;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 类名:reverseVowels_345
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-19 11:45
 **/
public class reverseVowels_345 {
    public static String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        Collections.addAll(set,'a','e','i','o','u');
        int i = 0;
        int j = s.length() - 1;
        char[] c = s.toCharArray();

        while(i < j && i != j){
            while(!set.contains(c[i])){
                i++;
            }
            while(!set.contains(c[j])){
                j--;
            }
            if(i < j ){
                swap(c,i,j);
                i++;
                j--;
            }
        }

        return String.valueOf(c);
    }
    public static void swap(char[] c,int i,int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseVowels(s));
    }
}
