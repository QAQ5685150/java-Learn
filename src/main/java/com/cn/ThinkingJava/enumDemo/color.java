package com.cn.ThinkingJava.enumDemo;

import java.util.Scanner;

/**
 * 类名:color
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-07-30 14:30
 **/
public enum  color {
    RED,GREEN,YELLOW;

}

class Trival{
    color color1 = color.RED;

    @Override
    public String toString() {
        return "The Trival's color is : "+ color1;
    }

    public void change(){
        switch (color1){
            case RED :
                color1 = color.GREEN;
                break;
            case GREEN :
                color1 = color.YELLOW;
                break;
            case YELLOW:
                color1 = color.RED;
                break;
            default:
                color1 = color.RED;
        }
    }
}

class test03{
    public static void main(String[] args) {
        Trival t = new Trival();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入要循环的次数：");
        int i1 = sc.nextInt();
        for (int i = 0; i < i1; i++) {
            System.out.println(t);
            t.change();
        }
    }
}


