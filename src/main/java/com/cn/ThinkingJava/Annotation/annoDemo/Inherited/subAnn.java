package com.cn.ThinkingJava.Annotation.annoDemo.Inherited;

import java.lang.annotation.*;

/**
 * 类名:subAnn
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-29 11:15
 **/
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention( RetentionPolicy.RUNTIME)
@Documented
public @interface subAnn {
}
