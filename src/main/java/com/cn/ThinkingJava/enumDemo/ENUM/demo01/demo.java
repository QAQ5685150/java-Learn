package com.cn.ThinkingJava.enumDemo.ENUM.demo01;

import java.util.Scanner;

/**
 * 类名:demo
 * 描述:enum + switch(Integer控制分支)
 * 姓名:南风
 * 日期:2021-07-23 13:34
 **/
public class demo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        eDemo demo = null;
        switch (new Integer(i)){
            case 1:
                 demo = eDemo.RED;
                 break;
            case 2:
                 demo = eDemo.BLUE;
                 break;
            case 3:
                 demo = eDemo.GREEN;
                 break;
        }

        switch (demo){
            case RED:
                System.out.println("red");
                break;
            case BLUE:
                System.out.println("blue");
                break;
            case GREEN:
                System.out.println("green");
                break;
        }

    }
}
