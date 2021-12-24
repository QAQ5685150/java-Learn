package com.cn.algorithm;

/**
 * 类名:truncateSentence_1816
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-12-06 9:26
 **/
public class truncateSentence_1816 {

    public static void main(String[] args) {
        System.out.println(truncateSentence1("Hello how are you Contestant", 4));
    }

    public static String truncateSentence(String s, int k) {
        String[] s1 = s.split(" ");
        String ans = "";
        for (int i = 0; i < k; i++) {
            ans += s1[i];
        }
        return ans;
    }

    /**
    *功能描述:对“ ”空字符串计数，表示当前到了第几个单词，若k-到0，返回（0，i）字符串字串，否则返回整个字符串
    *@param s
    *@return String
    **/
    public static String truncateSentence1(String s, int k) {
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ' && --k == 0){
                return s.substring(0,i);
            }
        }
        return s;
    }
}
