package com.cn.ThinkingJava.Annotation.database;

import java.lang.annotation.*;

/**
 * 类名:DBtable
 * 描述:标注创建数据库的名称，标注在class类上 要用---TYPE：类、接口（包括注解类型）或者 enum 声明
 * 姓名:南风
 * 日期:2021-08-19 15:35
 **/
@Documented
@Target({ElementType.FIELD,ElementType.PACKAGE,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DBtable {
    public String name() default "";
}
