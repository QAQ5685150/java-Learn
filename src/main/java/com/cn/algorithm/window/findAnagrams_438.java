package com.cn.algorithm.window;

import java.util.*;

/**
 * 类名:findAnagrams_438
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-29 10:24
 **/
public class findAnagrams_438 {

    /**
     * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     *
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
    **/
    public static void main(String[] args) {
        String t1 = "abcbbcabbacb";
        String t2 = "abc";
        System.out.println(findAnagrams(t1,t2));
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b) -> b - a);
        for (int i = 0; i < 10; i++) {
            pq.add(i);
        }
        while (!pq.isEmpty()){
            System.out.print(pq.poll() + " ");
        }

    }

    /**
    *功能描述:滑动窗口
    *@param s
    *@param p
    *@return java.util.List<java.lang.Integer>
    **/
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length(), m = p.length();
        int[] cnt = new int[26];
        for (int i = 0; i < m; i++) cnt[p.charAt(i) - 'a']++;
        int a = 0;
        for (int i = 0; i < 26; i++) if (cnt[i] != 0) a++;
        for (int l = 0, r = 0, b = 0; r < n; r++) {
            // 往窗口增加字符，进行词频的抵消操作，如果抵消后词频为 0，说明有一个新的字符词频与 p 完全相等
            if (--cnt[s.charAt(r) - 'a'] == 0) b++;
            // 若窗口长度超过规定，将窗口左端点右移，执行词频恢复操作，如果恢复后词频为 1（恢复前为 0），说明少了一个词频与 p 完全性相等的字符
            if (r - l + 1 > m && ++cnt[s.charAt(l++) - 'a'] == 1) b--;
            if (b == a) ans.add(l);
        }
        return ans;
    }

    public static List<Integer> findAnagrams1(String s, String p) {
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


    public static List<Integer> findAnagrams3(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        int[] w1 = new int[26];
        int[] w2 = new int[26];

        if(cp.length > cs.length) return new ArrayList<>();

        for (int i = 0; i < cp.length; i++) {
            w1[cs[i] - 'a']++;
            w2[cp[i] - 'a']++;
        }
        if(Arrays.equals(w1,w2)) res.add(0);

        for (int i = cp.length; i < cs.length; i++) {
            w1[cs[i] - 'a']++;
            w1[cs[i - cp.length] - 'a']--;

            if(Arrays.equals(w1,w2)){
                res.add(i - cp.length + 1);
            }
        }
        return res;
    }

}
