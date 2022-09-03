package com.cn.DesignModel.strategy;

/**
 * 类名:exec
 * 描述:简单工厂 + 策略模式 实例化策略
 * 姓名:南风
 * 日期:2021-12-02 17:13
 **/
public class exec {

    //组合接口，构造器传入具体实现，方法调用执行对应实现
    private plan plan;

    public exec(String strategy) {
        switch (strategy){
            case "A":
                plan = new planA();
                break;
            case "B":
                plan = new planB();
                break;
        }
    }

    public void execute(){
        plan.doPlan();
    }
}

class test{
    public static void main(String[] args) {
        exec exec = new exec("A");
        exec.execute();
        exec exec1 = new exec("B");
        exec1.execute();
    }
}
