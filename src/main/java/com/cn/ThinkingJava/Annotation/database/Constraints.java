package com.cn.ThinkingJava.Annotation.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类名:Constraints
 * 描述:标注字段在sql中加入索引 是否主键，是否非空，是否唯一
 * 姓名:南风
 * 日期:2021-08-19 15:31
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
    boolean primaryKey() default false;
    boolean allowNull() default true;
    boolean unique() default false;
}
