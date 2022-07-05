package com.cn.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.string
 * @Time: 2022-07-04 10:05
 **/
public class findAnagrams_438 {

    public static void main(String[] args) {
        for (Integer anagram : findAnagrams2("cbaebabacd", "abc")) {
            System.out.print(anagram + " ");
        }
    }

    public static List<Integer> findAnagrams(String s, String p) {
//一样的滑窗思路，题解用的26字母hash数组计数的方法，我用的hashSet
//hashSet会出现的问题：p-abc  s-babc 出现错误答案，因为bab这个串在我的版本里也会被判断为是一个
//子串，因为我用的set.contains（）判断是否滑窗的
//        int len1 = s.length() - 1;
//        int len2 = p.length() - 1;
//        HashSet<Character> set = new HashSet<>();
//        List<Integer> list = new ArrayList<>();
//        for (char c : p.toCharArray()) {
//            set.add(c);
//        }
//        for (int i = 0; i <= len1 - len2; i++) {
//            int index = i;
//            int tmp = 0;
//            while (index - i <= len2 && index <= len1){
//                if(set.contains(s.charAt(index))){
//                    tmp++;
//                }
//                index++;
//            }
//            if(tmp == len2 + 1) list.add(i);
//        }
//        return list;
        List<Integer> list = new ArrayList<>();
        if(p.length() > s.length()){
            return list;
        }
        int[] ss = new int[26];
        int[] pp = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            ++ss[s.charAt(i) - 'a'];
            ++pp[p.charAt(i) - 'a'];
        }
        //第一步就相等的情况特殊考虑直接加入0位置的index
        if(Arrays.equals(ss,pp)){
            list.add(0);
        }
        for (int i = 0; i < s.length() - p.length(); i++) {
            --ss[s.charAt(i) - 'a'];
            ++ss[s.charAt(i + p.length()) - 'a'];

            if(Arrays.equals(ss,pp)){
                list.add(i + 1);
            }
        }
        return list;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }


}
