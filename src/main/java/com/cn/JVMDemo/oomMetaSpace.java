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
     * Ԫ�������ڴ����
     *
     * jvm options:
     * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m -XX:+UseParNewGC -XX:+UseConcMarkSweepGC
     * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=hprof/metadata-oom
     */

        public static void main(String[] args) {
            cglibCreate();
        }

        public static void cglibCreate() {
            int count = 0;
            while (true) {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(Test.class);
                // �����и���������
                enhancer.setUseCache(false);
                enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o, objects));

                Test testProxy = (Test) enhancer.create();
                System.out.println("��ǰ������ " + (++count) + "��������");
            }
        }


        static class Test {
        }
}
