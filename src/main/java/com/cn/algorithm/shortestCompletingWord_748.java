package com.cn.algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * @class: shortestCompletingWord_748
 * @description: TODO
 * @author: 南风
 * @date: 2021-12-10 14:55
 **/
public class shortestCompletingWord_748 {

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
