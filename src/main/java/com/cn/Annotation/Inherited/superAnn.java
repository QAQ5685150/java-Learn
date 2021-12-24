package com.cn.Annotation.Inherited;

import java.lang.annotation.*;

/**
 * 类名:superAnn
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-29 11:13
 **/
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.TYPE , ElementType.ANNOTATION_TYPE , ElementType.METHOD , ElementType.FIELD})
@Inherited
public @interface superAnn {
}
