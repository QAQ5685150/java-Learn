package com.cn.ThinkingJava.Annotation.annoDemo;

/**
 * 类名:Fruits
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-18 11:25
 **/
public abstract class Fruits {

    public Integer price;

    public Integer pack;

    public Fruits(Integer price, Integer pack) {
        this.price = price;
        this.pack = pack;
    }

    public void show(){
        System.out.println("price:" + price + " pack fee:" + pack);
    }

    public abstract void sellFruits();

}
