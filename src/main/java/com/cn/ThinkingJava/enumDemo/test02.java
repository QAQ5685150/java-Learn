package com.cn.ThinkingJava.enumDemo;

import java.util.stream.Stream;

/**
 * 类名:test02
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-07-30 14:14
 **/
public enum test02 {

    ZHU_GE_LIANG("卧龙",35),
    ZHANG_FEI("双板斧",30),
    ZHAO_YUN("七进七出",25),
    GUAN_YU("忠义",40);

    private String description;
    private int age;

    //重写了foreach对打印enum的影响
    @Override
    public String toString() {
        return "test02{" +
                "description='" + description + '\'' +
                ", age=" + age +
                '}';
    }

    test02(String description, int age) {
        this.description = description;
        this.age = age;
    }
    public String getDes(){
        return this.description;
    }
    public int getAge(){
        return this.age;
    }
}

class test2{
    public static void main(String[] args) {
        for (test02 value : test02.values()) {
            System.out.println(value + ":" + value.getDes() + "  年龄：" + value.getAge());
        }
        //enum的流式计算  foreach
        Stream.of(test02.values()).forEach(System.out::println);
    }
}
