package com.cn.JdkDemo.proxy.cglib;

import com.cn.JdkDemo.reflection.demo01;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 类名: proxyFactory
 * 描述: cglibDemo 创建Enhancer代理对象，
 * 姓名: @author南风
 * 日期: 2022-01-12 10:46
 **/
public class proxyFactory implements MethodInterceptor {

    private Class clazz;

    private Enhancer enhancer = new Enhancer();

    public proxyFactory(Class clazz) {
        this.clazz = clazz;
        enhancer.setSuperclass(clazz);
    }

    public Object getNewInstance(){
        return enhancer.create(this.clazz,this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("do before ……");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("do after ……");
        return o1;
    }

    public static void main(String[] args) {
        proxyFactory pf = new proxyFactory(demo01.class);
        demo01 newInstance = (demo01)pf.getNewInstance();
        newInstance.NotStatic();
    }
}
