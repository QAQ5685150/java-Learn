package com.cn.algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-04-24 19:56
 * @Description: TODO
 * @Project_name: java-learn
 */
public class binaryGap_868 {

    public static void main(String[] args) {

        System.out.println(binaryGap(5));

    }

    public static int binaryGap(int n) {
        String s = getBinary(n);
        List<Integer> list = new ArrayList();
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) - '0' == 1){
                list.add(i);
            }
        }

        for (int i = 1; i < list.size(); i++) {
            max = Math.max(max, list.get(i) - list.get(i - 1));
        }
        return max;
    }

    public static String getBinary(int n){
        StringBuilder res = new StringBuilder();
        while(n > 0){
            int tmp = n % 2;
            n /= 2;
            res.append(tmp);
        }
        return res.reverse().toString();
    }
}
