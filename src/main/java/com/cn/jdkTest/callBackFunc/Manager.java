package com.cn.jdkTest.callBackFunc;

/**
 * 类名:Manager
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-09 16:19
 **/
public class Manager {
    String task;

    public void Manager(Personal personal,String task){
        this.task = task;
        personal.doSomething(this,task);
    }

    public void callBack(String result){
        System.out.println("电话响起，估计是事情做完了……"+result);
    }
}
