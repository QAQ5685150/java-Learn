package com.cn.JDKDemo.callBackFunc;

/**
 * 类名:Personal
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-09 16:19
 **/
public class Personal {

    public void doSomething(Manager manager,String task){
        System.out.println("收到任务，正在做：" + task);
        String result = "ok!";
        manager.callBack(result);
    }
}
