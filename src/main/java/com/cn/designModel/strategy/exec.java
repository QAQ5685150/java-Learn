package com.cn.designModel.strategy;

/**
 * 类名:exec
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-12-02 17:13
 **/
public class exec {

    //组合接口，构造器传入具体实现，方法调用执行对应实现
    private plan plan;

    public exec(plan p) {
        this.plan = p;
    }

    public void execute(){
        plan.doPlan();
    }
}

class test{
    public static void main(String[] args) {
        exec exec = new exec(new planA());
        exec.execute();
        exec exec1 = new exec(new planB());
        exec1.execute();
    }
}
