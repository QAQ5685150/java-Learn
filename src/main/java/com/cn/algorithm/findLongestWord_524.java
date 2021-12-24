package com.cn.algorithm;

import java.util.*;

/**
 * 类名:findLongestWord_524
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-14 17:40
 **/
public class findLongestWord_524 {

    public static void main(String[] args) {
        String s = "abce";
        List<String> dictionary = new ArrayList<>();
        Collections.addAll(dictionary,"abe","abc");
        System.out.println(findLongestWord(s,dictionary));

    }


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
}
