package com.cn.JdkDemo.AQS;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface check {

    String value() default "";

    Class<?> check();
}
