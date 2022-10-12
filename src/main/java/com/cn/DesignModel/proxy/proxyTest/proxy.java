package com.cn.DesignModel.proxy.proxyTest;

/**
 * @Author: Linxx
 * @Package: com.cn.DesignModel.proxy
 * @Time: 2022-10-12 10:11
 * @Description: TODO
 **/
public class proxy {

    origin originClazz;

    public proxy(origin originClazz) {
        this.originClazz = originClazz;
    }

    public void proxyOrigin(){
        System.out.println("method before");
        originClazz.normalMethod();
        System.out.println("method after");
    }

    public static void main(String[] args) {

    }
}
