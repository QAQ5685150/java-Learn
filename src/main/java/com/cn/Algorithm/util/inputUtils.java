package com.cn.Algorithm.util;

import java.util.Scanner;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-02-06 23:21
 * @Description: 控制台输入工具类
 * @Project_name: java-learn
 */
public class inputUtils {

    private static Scanner scanner;

    /**
     * 尝试用static直接复制scanner 出现了numberFormatException 不知道是不是因为static让两个静态方法共用了同一个Scanner对象
     * @return
     */
    public static int getInt(){
        scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        return i;
    }

    /**
     * 控制台输入数组
     * @return
     */
    public static int[] getArr(){
        scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int[] arr = new int[s1.length];
        if("".equals(s1)){
            throw new RuntimeException("NND!你输入啊！");
        }
        for (int i = 0; i < s1.length; i++) {
            arr[i] = Integer.valueOf(s1[i]);
        }
        return arr;
    }

    /**
     * 控制台输入字符串
     * @return
     */
    public static String getString(){
        scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        return s;
    }

}
