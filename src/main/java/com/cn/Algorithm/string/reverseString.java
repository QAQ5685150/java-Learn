package com.cn.Algorithm.string;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-03-20 11:03
 * @Description: 单词反转
 * @Project_name: java-learn
 */
public class reverseString {


    public static void main(String[] args) {
        System.out.println(reverse("this is a test"));

        System.out.println(re("love"));
    }


    public static String reverse(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        StringBuilder reverse = stringBuilder.reverse();
        StringBuilder sb = new StringBuilder();

        int l = 0;
        for (int i = 0; i < reverse.length() - 1; i++) {
            if(reverse.charAt(i + 1) == ' '){
                StringBuilder tmp = new StringBuilder(reverse.substring(l,i + 1));
                StringBuilder reverse1 = tmp.reverse();
                sb.append(reverse1).append(" ");
                l = i + 2;
            }
            if(i == reverse.length() - 2){
                StringBuilder tmp = new StringBuilder(reverse.substring(l,i + 2));
                StringBuilder reverse1 = tmp.reverse();
                sb.append(reverse1);
            }
        }

        return sb.toString();
    }

    public static String re(String s){
        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse += s.charAt(i);
        }
        return reverse;
    }
}
