package com.cn.JdkDemo.reflection;

import com.cn.Pojo.user;
import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.esotericsoftware.reflectasm.FieldAccess;
import com.esotericsoftware.reflectasm.MethodAccess;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: Linxx
 * @Package: com.cn.JdkDemo.reflection
 * @Time: 2022-10-25 10:08
 * @Description: reflectASM ≤‚ ‘¿‡
 **/
public class reflectASM {
    public static void main(String[] args) throws Exception {
        // java reflection
        Class<user> clazz = user.class;
        Field field = clazz.getField("name");
        field.setAccessible(true);
        Method method = clazz.getMethod("setName", String.class);
        method.setAccessible(true);

        // reflection asm
        ConstructorAccess<user> ca = ConstructorAccess.get(clazz);
        FieldAccess fa = FieldAccess.get(user.class);
        MethodAccess ma = MethodAccess.get(user.class);

        // use for test
        user user = new user();
        int times = 100000000;

        // case0: common
        long startTime0 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            user = new user();
            user.name = "LXQ";
            user.setName("liuxianqiang");
        }
        System.out.println("common : " + (System.currentTimeMillis() - startTime0));

        // case1: java reflect
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            user = clazz.newInstance();
            field.set(user, "LXQ");
            method.invoke(user, "liuxianqiang");
        }
        System.out.println("java reflect : " + (System.currentTimeMillis() - startTime1));

        // case2: reflectasm use name
        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            user = ca.newInstance();
            fa.set(user, "name", "LXQ");
            ma.invoke(user, "setName", "liuxianqiang");
        }
        System.out.println("reflectasm use name : " + (System.currentTimeMillis() - startTime2));

        // case3: reflectasm use index
        int index1 = fa.getIndex("name");
        int index2 = ma.getIndex("setName");
        long startTime3 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            user = ca.newInstance();
            fa.set(user, index1, "LXQ");
            ma.invoke(user, index2, "liuxianqiang");
        }
        System.out.println("reflectasm use index : " + (System.currentTimeMillis() - startTime3));
    }
}
