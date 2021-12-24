package com.cn.Annotation;

import java.lang.annotation.*;

/**
 * 类名:FruitColor
 * 描述:水果颜色注解
 * 姓名:南风
 * 日期:2021-08-17 11:41
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    /**
     * 颜色枚举
     * @author peida
     *
     */
    public enum Color{
        BULE,
        RED,
        GREEN
    }

    /**
     * 颜色属性
     * @return
     */
    Color fruitColor() default Color.GREEN;

}
