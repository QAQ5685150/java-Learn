package com.cn.Annotation.Inherited;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 类名:test01
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-29 11:08
 **/
public class test01 {

    public static void main(String[] args) {
        father f = new father("tom","30");
        children c = new children("jim","2");
        System.out.println(f);
        System.out.println(c);
        f.walk();
        c.walk();

        Class<father> clazz1 = father.class;
        System.out.println(clazz1.getSimpleName());
        System.out.println(clazz1.getName());
        for (Field declaredField : clazz1.getDeclaredFields()) {
            for (Annotation annotation : declaredField.getAnnotations()) {
                System.out.println(annotation.annotationType().getSimpleName());
            }
        }
        System.out.println(clazz1.getDeclaredAnnotations().toString());

        System.out.println("");
        System.out.println("==========================");
        System.out.println("");

        Class<children> clazz2 = children.class;
        System.out.println(clazz2.getSimpleName());
        System.out.println(clazz2.getName());
        System.out.println("");
        System.out.println("==========================");
        System.out.println("");
        Constructor<?>[] constructors = clazz2.getConstructors();
        for (Constructor<?> constructor : constructors) {
            try {
                children cc = (children)constructor.newInstance("11", "11");
                System.out.println(cc.toString());
                cc.getClass().getMethod("walk").invoke(new children("12","12"));
                for (Method method : clazz2.getMethods()) {
                    method.invoke(new children("13","13"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
        System.out.println("==========================");
        System.out.println("");
        for (Field declaredField : clazz2.getDeclaredFields()) {
            System.out.println(declaredField.getName());
            System.out.println(declaredField.getType());
            System.out.println(declaredField.getAnnotatedType() == null ? "null ann" : declaredField.getAnnotatedType());
            System.out.println("");
        }
    }
}
