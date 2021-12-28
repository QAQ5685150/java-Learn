package com.cn.algorithm.string;

import java.util.Arrays;
import java.util.List;

/**
 * @class: shortestCompletingWord_748
 * @description: TODO
 * @author: 南风
 * @date: 2021-12-10 14:55
 **/
public class shortestCompletingWord_748 {

    /**
    *功能描述:给你一个字符串 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。
     *
     * 补全词 是一个包含 licensePlate 中所有字母的单词。
     *
     * 在匹配 licensePlate 中的字母时：
     *
     * 忽略licensePlate 中的 数字和空格 。
     * 不区分大小写。
     * 如果某个字母在 licensePlate 中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
     * 例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母 'a'、'b' （忽略大写）和两个 'c' 。
     * 可能的 补全词 有 "abccdef"、"caaacab" 以及 "cbca" 。
     *
     * 请你找出并返回 words 中的 最短补全词 。题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取 words 中 第一个 出现的那个。
    **/
    public static void main(String[] args) {
//        String licen = "1s3 PSt";
//        String[] words = new String[]{"step","steps","stripe","stepple"};
//        System.out.println(shortestCompletingWord(licen,words));
        List<String> a = null;
        for (String s : a) {

        }
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        String ans = "";
        int[] hash = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            int cur = licensePlate.toLowerCase().charAt(i) - 'a';
            if(cur >= 0) hash[cur]++;
        }
        for (String word : words) {
            int[] cp = Arrays.copyOf(hash,hash.length - 1 );
            for (char c : word.toCharArray()) {
                cp[c - 'a']--;
            }
            if(check(cp)){
                if("".equals(ans)) ans = word;
                ans = word.length() < ans.length() ? word : ans;
            }
        }
        return ans;
    }

    public static boolean check(int[] arr){
        for (int i : arr) {
            if(i != 0) return false;
        }
        return true;
    }
}
