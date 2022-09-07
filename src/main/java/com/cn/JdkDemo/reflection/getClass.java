package com.cn.JdkDemo.reflection;

import java.lang.reflect.Field;
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
        //classLoader.getResource("") 获取类路径名称
        System.out.println(classLoader.getResource("").toString());

        Class<?> aClass = getClass.class.getClassLoader().loadClass("com.cn.JdkDemo.reflection.demo01");
        System.out.println("========field=======");
        for (Field declaredField : aClass.getDeclaredFields()) {
            System.out.println(declaredField);
        }
        System.out.println("========method=======");
        for (Method method : aClass.getMethods()) {
            System.out.println(method);
        }

        System.out.println();
        System.out.println("========== classLoader 和 class.forname 的区别==============");
        System.out.println(" classLoader不进行加载类中的连接步骤 不会加载静态类");
        System.out.println();

        //class.forName加载要带上类路径
        Class<?> demo01 = Class.forName("com.cn.JdkDemo.reflection.demo01");
        System.out.println("========field=======");
        for (Field declaredField : demo01.getDeclaredFields()) {
            System.out.println(declaredField);
        }
        System.out.println("========method=======");
        Method[] methods = demo01.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }




    }
}
