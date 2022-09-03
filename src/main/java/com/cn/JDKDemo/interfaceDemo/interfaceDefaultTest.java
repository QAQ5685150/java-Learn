package com.cn.JDKDemo.interfaceDemo;

/**
 * 类名:interfaceDefaultTest
 * 描述:接口默认方法demo 看到currentHashMap接口的默认方法想到的，来试一试怎么用的
 * 姓名:南风
 * 日期:2021-11-19 14:06
 **/
public class interfaceDefaultTest implements interfaceDefault {
    @Override
    public void implementMethod() {
        System.out.println("this is a method override");
    }

    class inner implements interfaceDefault{

        @Override
        public void implementMethod() {
            System.out.println("this is a method that inner class override");
        }
    }

    static class staticInner implements interfaceDefault{
        @Override
        public void implementMethod() {
            System.out.println("this is a method that static inner class override");
        }
    }

    public static void main(String[] args) {
        interfaceDefault in = new interfaceDefaultTest();
        in.defaultMethod();
        in.implementMethod();

        interfaceDefaultTest inter = new interfaceDefaultTest();
        inter.defaultMethod();
        inter.implementMethod();

        inner inner = new interfaceDefaultTest().new inner();
        inner.defaultMethod();
        inner.implementMethod();

        interfaceDefault interfaceDefault  = new interfaceDefaultTest.staticInner();
        interfaceDefault.defaultMethod();
        interfaceDefault.implementMethod();
    }
}




