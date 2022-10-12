package com.cn.DesignModel.model;

/**
 * 类名:model
 * 描述:模板模式 抽象类
 * 姓名:南风
 * 日期:2021-12-06 10:50
 **/
public abstract class model {

    private String from;

    private String to;

    public model(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public void exec(){
        firstStep();
        secondStep();
        threadStep();
    }

    public void nextExec(){
        firstStep();
        secondStep();
        threadStep();
        forthStep();
    }

    protected void test(){
        System.out.println("this is a method from abstract class");
    }

    protected abstract void firstStep();

    protected abstract void secondStep();

    protected abstract void threadStep();

    protected abstract void forthStep();
}

class test{
    public static void main(String[] args) {
        model m1 = new modelOne("冰箱","大象");
        m1.exec();
        System.out.println("=============");
        model m2 = new modelTwo("冰箱","大象","鸵鸟");
        m2.nextExec();
        System.out.println("=============");
        m2.firstStep();
        System.out.println("=============");

        //抽象类可以实例化，但实例化的对象必须重写抽象类的抽象方法
        model m = new model("from","to") {
            @Override
            protected void firstStep() {

            }

            @Override
            protected void secondStep() {

            }

            @Override
            protected void threadStep() {

            }

            @Override
            protected void forthStep() {

            }
        };

        m.test();
    }
}
