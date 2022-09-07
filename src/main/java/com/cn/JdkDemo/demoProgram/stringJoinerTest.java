package com.cn.JdkDemo.demoProgram;

import java.util.StringJoiner;

/**
 * 类名: stringJoinerTest
 * 描述: stringJoiner demo
 * 姓名: @author南风
 * 日期: 2022-02-17 9:49
 **/
public class stringJoinerTest {

    public static void main(String[] args) {

        //StringJoiner.add
        StringJoiner sj = new StringJoiner(":", "[", "]");
        sj.add("George").add("Sally").add("Fred");
        System.out.println(sj.toString());//[George:Sally:Fred]

        //StringJoiner.merge
        StringJoiner sj2 = new StringJoiner(" ");
        sj2.add("yyde").add("yygq").add("yyds");
        System.out.println(sj2.toString());
        StringJoiner merge = sj2.merge(sj);
        System.out.println(merge);
    }
}
