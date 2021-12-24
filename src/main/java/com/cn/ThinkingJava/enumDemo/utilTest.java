package com.cn.ThinkingJava.enumDemo;

import java.util.*;

/**
 * 类名:utilTest
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-07-30 15:13
 **/


enum activity{
    SITTING, LYING, STANDING, HOPPING,
    RUNNING, DODGING, JUMPING, FALLING, FLYING
        }

enum others{
    o,t,h,e,r,s
}

public class utilTest {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(EnumUtils.random(activity.class) + " ");
        }

        System.out.println("");

        for (int i = 0; i < 20; i++) {
            System.out.print(EnumUtils.random(others.class) + " ");
        }

        System.out.println("");

        List<Integer> list = new LinkedList<>();
        Collections.addAll(list,1,3,4,5,2,7);
        list.forEach(a -> System.out.print(a + " "));
    }
}
