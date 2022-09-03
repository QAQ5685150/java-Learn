package com.cn.Algorithm.algoritmBook.niuke;

import java.util.Scanner;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-08-27 21:58
 * @Description: HJ29 字符串加解密
 * @Project_name: java-learn
 */
public class HJ29 {
    public static void main(String []args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        encoder(s1);
        decoder(s2);
    }
    public static void encoder(String str){
        char[] c = str.toCharArray();
        for(int i = 0; i < c.length; i++){
            char cur = c[i];
            if(Character.isAlphabetic(cur)){
                if (Character.isUpperCase(cur)) {
                    if(cur == 'Z'){
                        c[i] = 'a';
                        continue;
                    }
                    c[i] = (char) Character.toLowerCase (cur + 1);
                }else {
                    if(cur == 'z') {
                        c[i] = 'A';
                        continue;
                    }
                    c[i] = (char) Character.toUpperCase ((char)cur + 1);
                }
            }else {
                if(cur == '9'){
                    c[i] = '0';
                }else {
                    c[i] = (char) (cur + 1);
                }
            }
        }
        System.out.println(new String(c));
    }

    public static void decoder(String str){
        char[] c = str.toCharArray();
        for(int i = 0; i < c.length; i++){
            char cur = c[i];
            if(Character.isAlphabetic(cur)){
                if (Character.isUpperCase(cur)) {
                    if(cur == 'A'){
                        c[i] = 'z';
                        continue;
                    }
                    c[i] = (char) Character.toLowerCase (cur - 1);
                }else {
                    if(cur == 'a') {
                        c[i] = 'Z';
                        continue;
                    }
                    c[i] = (char) Character.toUpperCase ((char)cur - 1);
                }
            }else {
                if(cur == '0'){
                    c[i] = '9';
                }else {
                    c[i] = (char) (cur - 1);
                }
            }
        }
        System.out.println(new String(c));
    }
}