package com.cn.Proxy.dynamicProxy;

/**
 * 类名:Iuserdao2Impl
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-29 14:03
 **/
public class Iuserdao2Impl implements Iuserdao2{

    private int id;

    public Iuserdao2Impl(int id) {
        this.id = id;
    }

    @Override
    public int update() {
        System.out.println("update success");
        return id;
    }
}
