package com.cn.algorithm.doublePoint;

import java.util.*;

/**
 * 类名:findLongestWord_524
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-14 17:40
 **/
public class findLongestWord_524 {

    /**
     * 给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
     *
     * 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
    **/
    public static void main(String[] args) {
        String s = "abce";
        List<String> dictionary = new ArrayList<>();
        Collections.addAll(dictionary,"abe","abc");
        System.out.println(findLongestWord(s,dictionary));
    }


    /**
    *功能描述:TODO
    *@param s
    *@param dictionary
    *@return java.lang.String
    **/
    public static String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        char[] chars = s.toCharArray();
        Collections.sort(dictionary);
        System.out.println(dictionary.toString());

        for (int i = 0; i < dictionary.size(); i++) {
            int maxlen = 0;
            String cur = dictionary.get(i);
            int simple = getSimple(cur, s);
            if(simple > ans.length()){
                ans = cur;
            }
        }
        return ans;
    }

    public static int getSimple(String source,String target){
        int same = 0;
        int i = 0;
        int j = 0;
        while (i < source.length() && j < target.length()){
            if(source.charAt(i) == target.charAt(j)){
                i++;
                j++;
                same++;
            }else {
                j++;
            }
        }
        return same;
    }

    /**
    *功能描述:双指针
    *@param s
    *@param dictionary
    *@return java.lang.String
    **/
    public String findLongestWord1(String s, List<String> dictionary) {
        String res = "";
        for (String t : dictionary) {
            int i = 0, j = 0;
            //通过修该指针找到能否通过“删除”匹配当前字符串 t
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    ++i;
                }
                ++j;
            }
            //i移动到当前字符串t末尾，说明可以匹配到，判断是否最长且字典序最小

            if (i == t.length()) {
                //若 t的长度比前面匹配到的字符串长度长    t.compareTo(res) < 0 -> t和res字符串比较字典序
                if (t.length() > res.length() || (t.length() == res.length() && t.compareTo(res) < 0)) {
                    res = t;
                }
            }
        }
        return res;
    }
}
