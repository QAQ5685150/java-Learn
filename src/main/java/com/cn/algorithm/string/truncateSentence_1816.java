package com.cn.algorithm.string;

/**
 * 类名:truncateSentence_1816
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-12-06 9:26
 **/
public class truncateSentence_1816 {

    /**
    *功能描述:句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
     *
     * 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
     * 给你一个句子  和一个整数  ，请你将 s 截断 ，使截断后的句子仅含 前  个单词。返回 截断  后得到的句子。
     *
     * 输入：s = "Hello how are you Contestant", k = 4
     * 输出："Hello how are you"
     * 解释：
     * s 中的单词为 ["Hello", "how" "are", "you", "Contestant"]
     * 前 4 个单词为 ["Hello", "how", "are", "you"]
     * 因此，应当返回 "Hello how are you"
     *
    **/
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
