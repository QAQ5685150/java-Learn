package com.cn.jdkTest;

import java.util.HashMap;

/**
 * 类名:test02
 * 描述:清空数组缓存
 * 姓名:南风
 * 日期:2021-07-22 13:25
 **/
public class test02 {
    public static void main(String[] args) {
        Long[] id1 = new Long[4];
        System.out.println(id1);
        Long[] ids = new Long[]{1L,2L,1L,2L,1L,2L};
        for (Long id : ids) {
            System.out.println(id);
        }
        for (Long id : ids) {
            id = null;
        }
        System.out.println(ids);
        ids[1] = 1L;
        System.out.println(ids);

    }
}
