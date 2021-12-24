package com.cn.Annotation;

import java.lang.annotation.*;

/**
 * 类名:FruitProvider
 * 描述:水果供应者注解
 * 姓名:南风
 * 日期:2021-08-17 11:43
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    /**
     * 供应商编号
     * @return
     */
    public int id() default -1;

    /**
     * 供应商名称
     * @return
     */
    public String name() default "";

    /**
     * 供应商地址
     * @return
     */
    public String address() default "";
}
