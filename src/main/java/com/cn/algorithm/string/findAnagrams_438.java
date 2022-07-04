package com.cn.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
        int len1 = s.length() - 1;
        int len2 = p.length() - 1;
        HashSet<Character> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (char c : p.toCharArray()) {
            set.add(c);
        }
        for (int i = 0; i <= len1 - len2; i++) {
            int index = i;
            int tmp = 0;
            while (index - i <= len2 && index <= len1){
                if(set.contains(s.charAt(index))){
                    tmp++;
                }
                index++;
            }
            if(tmp == len2 + 1) list.add(i);
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
