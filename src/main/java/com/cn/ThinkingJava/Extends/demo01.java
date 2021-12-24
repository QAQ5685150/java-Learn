package com.cn.ThinkingJava.Extends;

import java.util.*;

/**
 * 类名:demo01
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-07-30 15:52
 **/
class demo01 {
    demo01(int i){
        System.out.println("demo01 constructor");
    }
}

class demo02 extends demo01{

    demo02(int i) {
        super(i);
        System.out.println("demo02 constructor");
    }
}

class demo03 extends demo02 {
    demo03() {
        super(11);
        System.out.println("demo03 constructor");
    }


    public static void main(String[] args) {
        //RandomStream();

        MapforEach();
    }

    /**
    *功能描述:Random的stream流计算demo
    *@returnvoid
    **/
    private static void RandomStream() {
        new Random(53).
                ints(3,54).
                limit(9).
                distinct().
                sorted().forEach(System.out::println);
    }

    /**
    *功能描述:HashMap的两种便利方式，一种foreach传入接口，一种用entrieSet的Iterator去遍历
    *@returnvoid
    **/
    private static void MapforEach() {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        map.put(1,10);
        map.put(2,20);
        map.put(3,30);
        map.put(0,0);
        map.forEach((a,b) ->{
            System.out.println(a + " : "+ b );
        });


        System.out.println("------------");

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            System.out.println(next.getKey() + " : " + next.getValue());
        }
    }
}

