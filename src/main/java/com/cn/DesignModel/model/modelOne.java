package com.cn.DesignModel.model;

/**
 * 类名:modelOne
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-12-06 10:53
 **/
public class modelOne extends model{

    private String from;

    private String to;

    public modelOne(String from, String to) {
        super(from, to);
        this.from = from;
        this.to = to;
    }

    @Override
    protected void firstStep() {
        System.out.println("step1:" + "把" + this.from + "打开");
    }

    @Override
    protected void secondStep() {
        System.out.println("step2:" + "把" + this.to + "放到" + this.from + "里");
    }

    @Override
    protected void threadStep() {
        System.out.println("step3:" + "把" + this.from + "关上");
    }

    @Override
    protected void forthStep() {

    }
}
