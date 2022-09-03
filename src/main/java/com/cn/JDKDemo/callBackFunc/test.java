package com.cn.JDKDemo.callBackFunc;

/**
 * 类名:test
 * 描述:程序回调 demo
 * 姓名:南风
 * 日期:2021-09-09 16:19
 **/
public class test {

    public static void main(String[] args) {
        Manager manager = new Manager();

        manager.Manager(new Personal(),"开车接孩子放学");
    }
}
