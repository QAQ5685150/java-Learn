package com.cn.ThinkingJava.equals;

/**
 * 类名:EqualityFactory
 * 描述: EqualityFactory接口提供make()函数来生成一个Equaity对象，这样不同的EqualityFactory能够生成Equality不同的子类。
 * 姓名:南风
 * 日期:2021-08-19 16:31
 **/
public interface EqualityFactory {
    Equality make(int i, String s, double d);
}
