package com.cn.Algorithm.string;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-04-01 13:40
 * @Description: TODO
 * @Project_name: java-learn
 */
public class longestPalindrome_05 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbadasddsa"));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        int max = 0;
        String res = "";
        for (int i = 1; i < len - 1; i++) {
            String s1 = getLongest(s, i, i);
            String s2 = getLongest(s, i, i + 1);
            int cur = Math.max(s1.length(),s2.length());
            if(cur > max){
                max = cur;
                res = s1.length() == cur ? s1 : s2;
            }
        }
        return res;
    }

    /**
     * 这里可以优化，只返回下表，而不是每一次都返回一个s.subString()，很费时间，直接返回最左下表然后计算，返回最后的subString就好了
     * @param s
     * @param l
     * @param r
     * @return
     */
    public static String getLongest(String s,int l,int r){
        char[] chars = s.toCharArray();
        String str = "";
        while (l >= 0 && r + 1 <= s.length()){
            if(chars[l] == chars[r]){
                str = s.substring(l,r + 1);
            }else {
                break;
            }
            l--;
            r++;
        }
        return str;
    }
}
