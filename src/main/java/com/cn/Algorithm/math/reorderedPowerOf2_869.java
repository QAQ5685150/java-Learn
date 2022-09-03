package com.cn.Algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名:reorderedPowerOf2_869
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-10-28 17:58
 **/
public class reorderedPowerOf2_869 {

    /**
     * 给定正整数 N，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
     *
     * 如果我们可以通过上述方式得到2 的幂，返回 true；否则，返回 false。
     *
     * 输入：1
     * 输出：true
     *
     * 输入：10
     * 输出：false
    **/
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
