package com.cn.ThinkingJava.enumDemo;

/**
 * 类名:Shrubbery
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-07-30 14:07
 **/
public enum Shrubbery {

    GROUND,
    CRAWLING,
    HANGING

}

class test{
//ordinal() 方法返回一个 int 值，这是每个 enum 实例在声明时的次序，从 0 开始。
//可以使用==来比较 enum 实例，编译器会自动为你提供 equals() 和 hashCode() 方法。
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s + "ordinal:" + s.ordinal());
            System.out.print(
                    s.compareTo(Shrubbery.CRAWLING) + " ");
            System.out.print(
                    s.equals(Shrubbery.CRAWLING) + " ");
            System.out.println(s == Shrubbery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("********************");

        }
    }
}
