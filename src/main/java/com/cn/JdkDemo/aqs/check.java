package com.cn.JdkDemo.aqs;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface check {

    String value() default "";

    Class<?> check();
}
