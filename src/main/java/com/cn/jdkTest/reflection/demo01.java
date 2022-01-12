package com.cn.jdkTest.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 类名:demo01
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-03 15:19
 **/
public class demo01 {


    private static String testStatic;

    private String notStatic;

    static void staticMethod(){
        System.out.println("this is a static method");
    }

    public void NotStatic(){
        System.out.println("this is a method not static");
    }

    static {
        System.out.println("this is a static, classLoader will not execute this static");
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class class1 = Class.forName("com.cn.pojo.person");
        System.out.println("===========================================");

        System.out.println(class1.getName()); // 包名 + 类名
        System.out.println(class1.getSimpleName()); //类名

        System.out.println("===========================================");
        //获得字段 ：
        Field[] fields = class1.getFields(); //只能获得public的属性
        System.out.println(fields.length);

        Field[] fields2 = class1.getDeclaredFields(); //返回全部的属性，可以获得私有的
        System.out.println(fields2.length);

        for (Field field : fields2) {
            System.out.println("field=>\t" + field);
        }

        Field name = class1.getDeclaredField("name"); //获取指定的字段！
        System.out.println(name);

        //获得方法
        System.out.println("===========================================");

        Method[] methods = class1.getMethods(); //返回当前类和被继承的类的public方法
        System.out.println(methods.length);

        for (Method method : methods) {
            System.out.println("methods: " + method);
        }

        Method[] declaredMethods = class1.getDeclaredMethods(); //获得当前类的所有方法
        System.out.println(declaredMethods.length);

        for (Method method : declaredMethods) {
            System.out.println("declaredMethods: " + method);
        }

        System.out.println("=====");
    }
}
