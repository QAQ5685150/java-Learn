package com.cn.algorithm;

/**
 * 类名:reverseStr_541
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-20 15:22
 **/
public class reverseStr_541 {

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
