package com.cn.ThinkingJava.equals;

import java.util.Objects;

/**
 * 类名:Equality
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-19 16:31
 **/
public class Equality {
    protected int i;
    protected String s;
    protected double d;

    public Equality(int i, String s, double d) {
        this.i = i;
        this.s = s;
        this.d = d;
        System.out.println("made 'Equality'");
    }

    @Override
    public boolean equals(Object rval) {
        if(rval == null)
            return false;
        if(rval == this)
            return true;
        if(!(rval instanceof Equality))
            return false;
        Equality other = (Equality)rval;
        if(!Objects.equals(i, other.i))
            return false;
        if(!Objects.equals(s, other.s))
            return false;
        if(!Objects.equals(d, other.d))return false;
        return true;
    }

    public void test(String descr, String expected, Object rval) {
        System.out.format("-- Testing %s --%n" + "%s instanceof Equality: %s%n" +
                        "Expected %s, got %s%n",
                descr, descr, rval instanceof Equality,
                expected, equals(rval));
    }

    public static void testAll(EqualityFactory eqf) {
        Equality
                e = eqf.make(1, "Monty", 3.14),
                eq = eqf.make(1, "Monty", 3.14),
                neq = eqf.make(99, "Bob", 1.618);
        e.test("null", "false", null);
        e.test("same object", "true", e);
        e.test("different type",
                "false", Integer.valueOf(99));e.test("same values", "true", eq);
        e.test("different values", "false", neq);
    }

    public static void main(String[] args) {
        testAll( (i, s, d) -> new Equality(i, s, d));
    }

}
