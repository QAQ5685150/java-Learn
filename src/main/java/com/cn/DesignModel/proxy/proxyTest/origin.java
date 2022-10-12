package com.cn.DesignModel.proxy.proxyTest;

/**
 * @Author: Linxx
 * @Package: com.cn.DesignModel.proxy
 * @Time: 2022-10-12 10:11
 * @Description: TODO
 **/
public class origin {

    public static final void finalStaticMethod(){
        System.out.println("test if final static method can be proxy");
    }

    public static void staticMethod(){
        System.out.println("test if static method can be proxy");
    }

    public static final void finalMethod(){
        System.out.println("test if final method can be proxy");
    }

    public  void normalMethod(){
        System.out.println("test if normal method can be proxy");
    }
}
