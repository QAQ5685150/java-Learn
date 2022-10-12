package com.cn.JVMDemo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @Author: Linxx
 * @Package: com.cn.jvmDemo
 * @Time: 2022-08-23 13:25
 * @Description: TODO
 **/
public class oomMetaSpace {

    /**
     *
     * 元数据区内存溢出
     *
     * jvm options:
     * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m -XX:+UseParNewGC -XX:+UseConcMarkSweepGC
     * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=src\main\resources
     */

        public static void main(String[] args) {
            cglibCreate();
        }

        public static void cglibCreate() {
            int count = 0;
            while (true) {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(Test.class);
                // 这里有个缓存设置
                enhancer.setUseCache(false);
                enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o, objects));

                Test testProxy = (Test) enhancer.create();
                System.out.println("当前创建了 " + (++count) + "个代理类");
                testProxy.method();

            }
        }


        static class Test {

            public void method(){
                System.out.println("proxy method run" + Thread.currentThread().getName());
            }
        }
}
