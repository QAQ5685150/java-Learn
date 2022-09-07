package com.cn.JdkDemo.Thread.ThreadLocal;

/**
 * 类名:demo01
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-18 13:36
 **/
public class demo01 {

    public static ThreadLocal<Long[]> parentId = new ThreadLocal<>();

    public static void main(String[] args) {
        parentId.set(new Long[]{1L,5L,3L});

        new Thread( () ->
        {
            parentId.set(new Long[]{1L,2L,3L});
            System.out.println(parentId.get() + " from " + Thread.currentThread().getName());
            parentId.remove();
        }
        ).start();

        System.out.println(parentId.get() + " from " + Thread.currentThread().getName());

        for (Long aLong : parentId.get()) {
            System.out.print(aLong + " ");
        }
    }
}
