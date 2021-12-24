package com.cn.ThinkingJava.enumDemo.enumByInterface;

import com.cn.ThinkingJava.enumDemo.EnumUtils;


/**
 * 类名:Course
 * 描述:枚举类getvalue 小demo
 * 姓名:南风
 * 日期:2021-07-30 15:28
 **/
public enum Course {
    chuan_cai(Food.chuan_cai.class),
    xiang_cai(Food.xiang_cai.class),
    yue_cai(Food.yue_cai.class);

    private Food[] values;

    private Course(Class<? extends Food> kind){
        values = kind.getEnumConstants();
    }

    public Food randomSelection(){
        return EnumUtils.random(values);
    }
}

class Meal{
    public static void main(String[] args) {
        //getValue();
    }

    private static void getValue() {
        for (int i = 0; i < 5; i++) {
            for (Course value : Course.values()) {
                Food food = value.randomSelection();
                System.out.println(food);
            }
            System.out.println("============");
        }
    }

    private static int bitCal(int n){
        int res = 0;



        return res;
    }

}
