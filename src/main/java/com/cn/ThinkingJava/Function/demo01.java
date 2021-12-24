package com.cn.ThinkingJava.Function;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 类名:demo01
 * 描述:java 函数时编程的 ：： 用法，用来直接调用对象的方法，可以调用构造器方法、对象方法、
 * 姓名:南风
 * 日期:2021-10-26 14:45
 **/
public class demo01 extends father implements Ifunc{

    public static void main(String[] args) {
        demo01 demo01 = new demo01();
        // ：：调用父类方法返回函数式接口
        demo01.superDemo();
        //直接调用，返回一个Runnable接口
        Runnable func = demo01::func;
        Runnable runnable = demo01::get;

        //:: 返回的是一个函数式接口，可以直接放到接受函数时接口的方法里面运行
        new Thread(demo01::func).start();
        new Thread(demo01::get).start();

        Ifunc ifunc = demo01::new;
        System.out.println(ifunc.get());

        List<String> list = new ArrayList<>();
        list.stream().filter(x-> x.equals("ss")).limit(3).toArray();
        Collector<Object, ?, Map<Object, List<Object>>> objectMapCollector = Collectors.groupingBy(demo01::getList);
        Set<Collector.Characteristics> characteristics = objectMapCollector.characteristics();
    }

    private void superDemo() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"1111","22222");
        list.forEach(super::getInt);
    }

    private void func(){
        System.out.println("this is a func");
    }

    private Object getList(Object o){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList,1,4,3,6,2,4,68);
        return arrayList;
    }

    @Override
    public demo01 get() {
        System.out.println("this is a get");
        return new demo01();
    }
}


class father{
    public void getInt(String s){
        System.out.println(Integer.valueOf(s));
    }
}

interface Ifunc{
    demo01 get();
}
