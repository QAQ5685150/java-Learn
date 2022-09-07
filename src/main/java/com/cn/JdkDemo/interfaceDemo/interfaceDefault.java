package com.cn.JdkDemo.interfaceDemo;

/**
 * 类名:interfaceDefault
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-19 14:05
 **/
public interface interfaceDefault {


    default void defaultMethod(){
        System.out.println("this is a default method!");
    }

    void implementMethod();
}
