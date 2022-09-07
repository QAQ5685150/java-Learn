package com.cn.JdkDemo.demoProgram;

import java.io.*;
import java.util.Scanner;

/**
 * 类名:test02
 * 描述:java从控制台接收输入三种方式
 * 姓名:南风
 * 日期:2021-07-22 13:25
 **/
public class input_3way {

    public static void main(String[] args) {
        way1();
        //way2();
        //way3();

    }

    /**
     * 功能描述:scanner()对象接收控制台输入，while循环监听
     * @return void
     **/
    private static void way1() {
        Scanner scInt = new Scanner(System.in);
        int i = scInt.nextInt();
        System.out.println("nextInt："  + i);
        Scanner scLine = new Scanner(System.in);
        String line = scLine.nextLine();
        System.out.println("nextLine:" + line);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            System.out.println(s);
        }
    }

    /**
     * 功能描述:InputStreamReader和BufferedReader方法
     *     优点: 可以获取键盘输入的字符串
     *     缺点: 如何要获取的是int,float等类型的仍然需要转换
     * @return void
     **/
    private static void way2() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {

            String s = br.readLine();
            System.out.println(s);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能描述: System.in和System.out方法
     *    缺点一: 该方法能获取从键盘输入的字符，但只能针对一个字符的获取
     *    缺点二: 获取的只是char类型的。如果想获得int,float等类型的输入,比较麻烦。
     * @return void
     **/
    private static void way3() {
        try {
            char c = (char)System.in.read();
            System.out.println(c);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
