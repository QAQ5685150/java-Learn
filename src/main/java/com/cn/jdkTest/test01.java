package com.cn.jdkTest;

import java.nio.file.Files;
import java.util.Arrays;

/**
 * 类名:test01
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-07-22 13:19
 **/

public class test01 {

    public static void main(String[] args) {
        Integer a = 100,b = 100,c = 150,d = 150;
        System.out.println(a == b);
        System.out.println(c == d);


        Character a1 = 126,b1 = 126,c1 = 128,d1 = 128;
        System.out.println(a1 == b1);
        System.out.println(c1 == d1);

        String s = "\u4f18\u79c0";
        System.out.println(s);//= = 优秀的utf-8编码

        System.out.println(row(3));

        Integer[] integers = new Integer[7];
        Arrays.fill(integers,1);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    public static int row(int no){
        int count = 0;
        while (no > 0){
            no /= 2;
            count++;
        }
        return count;
    }
}
