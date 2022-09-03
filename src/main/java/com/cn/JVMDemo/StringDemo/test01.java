package com.cn.JVMDemo.StringDemo;

/**
 * 类名: test01
 * 描述: String API Test
 * 姓名: @author南风
 * 日期: 2021-12-27 15:31
 **/
public class test01 {
    public static void main(String[] args) {
        String s1 = "aaa";
        String s2 = new String("aaa");
        StringBuilder s3 = new StringBuilder("aa");
        s3.append("a");

        System.out.println("======================");
        System.out.println("s1.intern() == s1 ?");
        System.out.println(s1.intern() == s1);
        System.out.println("s1.intern() == s2 ?");
        System.out.println(s2.intern() == s2);
        System.out.println("s2.intern() == s2 ?");
        System.out.println(s2.intern() == s2);
        System.out.println("s3.intern() == s3 ?");
        System.out.println(s3.toString().intern() == s3.toString());
        System.out.println("s1.equals(s2) ?");
        System.out.println(s1.equals(s2));
        System.out.println("s1 == s2 ?");
        System.out.println(s1 == s2);
        System.out.println("======================");

        String s4 = "aaa";
        System.out.println(s4 == s1);
        System.out.println(s3.toString().intern() == s1);
        //s2是new出来的对象，分配在java heap上
        System.out.println(s3.toString().intern() == s2);
        System.out.println("======================");

        //java 已经存在于常量池中了么？
        String s6 = new StringBuilder("ja").append("va").toString();
        System.out.println(s6.intern() == s6);


    }
}
