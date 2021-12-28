package com.cn.jdkTest.reflection;

import java.lang.reflect.Method;

/**
 * 类名:getClass
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-04 16:03
 **/
public class getClass {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = demo01.class.getClassLoader();
        Class<?> demo01 = Class.forName("demo01");
        Method[] methods = demo01.getMethods();
        for (Method method : methods) {
            method.invoke(String.class,"dd");
        }
        System.out.println(classLoader.getResource("").toString());

    }
}
