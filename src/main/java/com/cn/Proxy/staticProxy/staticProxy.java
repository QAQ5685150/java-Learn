package com.cn.Proxy.staticProxy;

/**
 * 类名:staticProxy
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-29 13:50
 **/
public class staticProxy {

    Iuserdao target;

    public staticProxy(Iuserdao iuserdao) {
        this.target = iuserdao;
    }

    public void proxy(){
        System.out.println("before proxy……");
        target.save();
        System.out.println("after proxy……");
    }

    public static void main(String[] args) {
        staticProxy sp = new staticProxy(new IuserdaoImpl("field1"));
        sp.proxy();
    }
}

