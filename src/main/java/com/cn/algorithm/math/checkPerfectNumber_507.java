package com.cn.algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名: checkPerfectNumber_507
 * 描述: TODO
 * 姓名: @author南风
 * 日期: 2021-12-31 17:10
 **/
public class checkPerfectNumber_507 {

    public static void main(String[] args) {
        List<Integer> list = checkPerfectNumber(33550338);
        list.forEach( n -> System.out.print(n + " "));
    }


    public static List<Integer> checkPerfectNumber(int num) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 1;i < num; i++){
            int res = 0;
            for (int j = 1; j < i; j++) {
                if(i % j == 0){
                    res += j;
                }
                if(res > num){
                    continue;
                }
            }
            if(res == i){
                list.add(i);
            }
        }
        return list;
    }
}
