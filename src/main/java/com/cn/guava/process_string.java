package com.cn.guava;

import com.cn.algorithm.util.printUtils;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * 类名: process_string
 * 描述: guava 字符串处理 demo
 * 姓名: @author南风
 * 日期: 2022-02-18 9:38
 **/
public class process_string {

    //连接器
    private static final Joiner joiner = Joiner.on(",").skipNulls();

    //分词器
    private static final Splitter splitter = Splitter.on(",").trimResults().omitEmptyStrings();

    //字符串匹配，CharMatcher.digit()只保留数字
    public static final CharMatcher charMatcher = CharMatcher.digit();

    public static void main(String[] args) {
        joiner_splitter_test();

        charMatcherTest();
    }

    public static void joiner_splitter_test(){
        String join = joiner.join(Lists.newArrayList("a","v",null,"d","d"));
        System.out.println("join = " + join);

        List<String> list = splitter.splitToList(join);
        System.out.print("splitter = " );
        printUtils.printArray(list);
    }

    public static void charMatcherTest() {
        //保留charMatcher创建时要的
        System.out.println(charMatcher.retainFrom("sdfaer789qwer!~@!"));

        //和上面正好相反
        System.out.println(charMatcher.removeFrom("123qwe123"));
    }
}
