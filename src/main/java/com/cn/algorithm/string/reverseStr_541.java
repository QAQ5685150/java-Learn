package com.cn.algorithm.string;

/**
 * 类名:reverseStr_541
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-20 15:22
 **/
public class reverseStr_541 {

    /**
     * 功能描述:给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
     *
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *
     * 输入：s = "abcdefg", k = 2
     * 输出："bacdfeg"
    **/
    public static void main(String[] args) {
        String s = "abcdefg";
        String test = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
        int k = 39;
        System.out.println(reverseStr(test, k));

    }

    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if(len < k){
            reverse(chars,0,len - 1);
            return String.valueOf(chars);
        }
        int index = 1;
        int start = 0;
        int last = len - (len % k);
        int lst1 = len / k;
        for(int i = 0;i < len;i++){
            if((i+1) % k == 0){
                if(index % 2 != 0 ) {
                    reverse(chars, start, i);
                }else {
                    start = i+1;
                }
                index++;
            }
            if(i == last && lst1 % 2 == 0){
                reverse(chars,i,len -1);
            }
        }
        return String.valueOf(chars);
    }

    public static void reverse(char[] c,int i,int j){
        while (i < j){
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
    }

}
