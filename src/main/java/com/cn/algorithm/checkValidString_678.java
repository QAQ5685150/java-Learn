package com.cn.algorithm;

/**
 * 类名:checkValidString_678
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-13 17:48
 **/
public class checkValidString_678 {

    public static void main(String[] args) {
        System.out.println(checkValidString("(((*))))"));
    }

    public static boolean checkValidString(String s) {
        int l = 0,r = 0,f = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = chars[i];
            if(c == '(') {
                l++;
                continue;
            }
            if(c == ')') {
                r++;
                continue;
            }
            else {
                f++;
                continue;
            }
        }
        if(l == r) return true;

        return l + f == r || r + f == l ? true : false;
    }
}
