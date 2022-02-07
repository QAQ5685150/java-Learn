package com.cn.algorithm.util;

import java.util.Scanner;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-02-06 23:21
 * @Description: ����̨���빤����
 * @Project_name: java-learn
 */
public class inputUtils {

    private static Scanner scanner;

    /**
     * ������staticֱ�Ӹ���scanner ������numberFormatException ��֪���ǲ�����Ϊstatic��������̬����������ͬһ��Scanner����
     * @return
     */
    public static int getInt(){
        scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        return i;
    }

    /**
     * ����̨��������
     * @return
     */
    public static int[] getArr(){
        scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int[] arr = new int[s1.length];
        if("".equals(s1)){
            throw new RuntimeException("NND!�����밡��");
        }
        for (int i = 0; i < s1.length; i++) {
            arr[i] = Integer.valueOf(s1[i]);
        }
        return arr;
    }

    /**
     * ����̨�����ַ���
     * @return
     */
    public static String getString(){
        scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        return s;
    }

}
