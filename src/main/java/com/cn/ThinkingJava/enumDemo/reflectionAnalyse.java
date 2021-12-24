package com.cn.ThinkingJava.enumDemo;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * 类名:reflectionAnalyse
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-07-30 14:43
 **/
enum ana{
    HERE,
    THERE
}


public class reflectionAnalyse {

    public static Set<String> analyze(Class<?> enumClass){
        System.out.println("----------开始分析" + enumClass + "--------");
        System.out.println("Interfaces:");
        for (Type t : enumClass.getGenericInterfaces()) {
            System.out.println(t);
        }
        System.out.println("Base:" + enumClass.getSuperclass());
        System.out.println("Methods:");
        Set<String> set = new TreeSet<>();
        for (Method method : enumClass.getMethods()) {
            set.add(method.getName());
        }
        System.out.println(set);
        return set;
    }

    public static void main(String[] args) {
        Set<String> analyze = analyze(ana.class);
        Set<String> enumAnalyze = analyze(Enum.class);
        System.out.println("Explore.containsAll(Enum)? " + analyze.containsAll(enumAnalyze));
        System.out.println("Explore.removeAll(Enum): ");
        analyze.removeAll(enumAnalyze);
        System.out.println(analyze);
    }

}
