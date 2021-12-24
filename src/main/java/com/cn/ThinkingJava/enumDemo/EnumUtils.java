package com.cn.ThinkingJava.enumDemo;

import java.util.Random;

/**
 * 类名:从enum枚举类中随机返回一个值
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-07-30 15:07
 **/
public class EnumUtils {

    private static Random random = new Random(39);

    public static <T extends Enum<T>> T random(Class<T> clazz){
        return random(clazz.getEnumConstants());
    }

    public static <T> T random(T[] values){

        return values[random.nextInt(values.length)];
    }
}
