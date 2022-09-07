package com.cn.JdkDemo.exception.tryCatch;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-01-27 13:06
 * @Description: try-catch-finally test_return
 * @Project_name: java-learn
 */
public class demo01 {
    public static void main(String[] args) {
        return01();
    }

    /**
     * 测试try-catch-finally  最终返回顺序
     * try和finally中都有return 最终会返回finally的return
     */
    public static int return01() {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,4,5,6,8,3,9);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        Map<Integer, Integer> collect = list.stream().map((i) -> i * 2).collect(Collectors.toMap((a) -> a, (b) -> b));
        Iterator<Map.Entry<Integer, Integer>> iterator = collect.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            System.out.println(next.getKey() + " " + next.getValue());
        }
        try{
            int a = 1;
            return a;
        }catch (Exception e){
            throw new RuntimeException();
        }
        finally {
            return 2;
        }
    }

}
