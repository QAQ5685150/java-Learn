package com.cn.algorithm.string;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-01-05 22:45
 * @Description: TODO
 * @Project_name: java-learn
 */
public class modifyString_1567 {

    private static char[] c = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','?'};

    /**
     * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
     *
     * 注意：你 不能 修改非 '?' 字符。
     *
     * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
     *
     * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
     * @param args
     */
    public static void main(String[] args) {
        String s = new String("b?a");
        System.out.println(modifyString(s));
    }

    /**
     * test  本来想个简单题感觉搞完，还是花了30多分钟……总是超边界，debug找问题，又要换debug的快捷键（笔记本Fn不干活了）
     *  “？？？” 这样的用例没想到 “b？a”没过，因为条件判断没有把a加上，导致又从a开始，重复了
     * @param s
     * @return
     */
    public static String modifyString(String s) {
        if(s.length() == 1 && s.equals("?")){
            return "a";
        }
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(chars[i] == '?'){
                if(i == 0){
                    int cur = 0 <= (chars[i + 1] - 'a') ? chars[i + 1] - 'a' : 26;
                    chars[i] = replace(26,cur);
                    continue;
                }
                if(i == s.length() - 1){
                    int cur = 0 <= (chars[i - 1] - 'a') ? chars[i - 1] - 'a' : 26;
                    chars[i] = replace(26,cur);
                    continue;
                }
                int l = chars[i - 1] - 'a';
                int r =  0 <= (chars[i + 1] - 'a') ? chars[i + 1] - 'a' : 26;
                chars[i] = replace(l,r);
            }
        }
        return new String(chars);
    }

    public static char replace(int j, int k){
        int index = 0;
        for(int i = 0; i < c.length - 1; i++){
            if(c[i] != c[j] && c[i] != c[k]){
                index = i;
                break;
            }
        }
        return c[index];
    }

    /**
     * 官方题解，替换法，我说为啥测试用例 “？？” 隔一个就变成b，替换是从c开始试起的啊
     * @param s
     * @return
     */
    public static String modifyString_ch(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            if (arr[i] == '?') {
                for (char ch = 'a'; ch <= 'c'; ++ch) {
                    if ((i > 0 && arr[i - 1] == ch) || (i < n - 1 && arr[i + 1] == ch)) {
                        continue;
                    }
                    arr[i] = ch;
                    break;
                }
            }
        }
        return new String(arr);
    }

}
