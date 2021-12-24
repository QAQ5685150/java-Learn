package com.cn.Annotation;

import java.lang.annotation.*;

/**
 * 类名:FruitName
 * 描述:水果名称注释类， java注释demo
 * 姓名:南风
 * 日期:2021-08-17 11:33
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface FruitName {
    String value() default "";
}
