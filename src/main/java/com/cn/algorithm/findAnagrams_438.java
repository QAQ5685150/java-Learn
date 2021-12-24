package com.cn.algorithm;

import java.util.*;

/**
 * 类名:findAnagrams_438
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-29 10:24
 **/
public class findAnagrams_438 {

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

}
