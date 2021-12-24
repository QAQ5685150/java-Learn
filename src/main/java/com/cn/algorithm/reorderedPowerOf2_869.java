package com.cn.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名:reorderedPowerOf2_869
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-10-28 17:58
 **/
public class reorderedPowerOf2_869 {

    public static void main(String[] args) {
        Integer i = 1;
        Integer index = 1;
        List<String> list = new ArrayList<>();
        while (i < Integer.MAX_VALUE){
            StringBuilder sb = new StringBuilder(String.valueOf(i));
            System.out.println(sb);
            list.add(sb.reverse().toString());
            i = 2 ^ (index++);
        }
        for (String s : list) {
            System.out.print(s + ",");
        }
    }
}
