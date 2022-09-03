package com.cn.Algorithm.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 类名:buddyStrings_859
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-23 16:02
 **/
public class buddyStrings_859 {

    /**
     * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
     *
     * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
     *
     * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
    **/
    public static void main(String[] args) {
        String test1 = "aa";
        String test2 = "aa";

        System.out.println(buddyStrings(test1,test2));
    }

    public static boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = goal.charAt(i);
            if(c1 != c2){
                map.put(c1,map.getOrDefault(c1,0) + 1);
                map.put(c2, map.getOrDefault(c2, 0) + 1);
            }
        }

        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        int def = 0;
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> next = iterator.next();
            def += next.getValue() == 2 ? 1 : 0;
        }
        return map.size() == 2 && def == 2;
    }
}