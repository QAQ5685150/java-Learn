package com.cn.JDKDemo.proxy.dynamicProxy;

import com.cn.JDKDemo.proxy.staticProxy.Iuserdao;
import com.cn.JDKDemo.proxy.staticProxy.IuserdaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 类名:dynProxy
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-29 13:54
 **/
public class dynProxy implements InvocationHandler {

    private Object targetObj;

    public dynProxy(Object targetObj) {
        this.targetObj = targetObj;
    }

    public Object getNewInstance(){
        return Proxy.newProxyInstance(targetObj.getClass().getClassLoader(), targetObj.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            System.out.println("before proxy……");
            proxy = method.invoke(targetObj, args);
            System.out.println("after proxy……");
        } catch (Exception e) {
            System.out.println("proxy failed……");
        }
        return proxy;
    }

    public static void main(String[] args) {
        dynProxy dy = new dynProxy(new IuserdaoImpl("field2"));
        //这里的Iuserdao newInstance就是一个代理对象Iuserdao是统一的接口，动态代理必须实现接口才能代理
        Iuserdao newInstance = (Iuserdao)dy.getNewInstance();
        newInstance.save();
        System.out.println("==========================");
        dynProxy dynProxy = new dynProxy(new Iuserdao2Impl(13));
        Iuserdao2Impl newInstance1 = (Iuserdao2Impl) dynProxy.getNewInstance();
        System.out.println("get return : " + newInstance1.update());
        System.out.println(9 / 10);
    }
}
