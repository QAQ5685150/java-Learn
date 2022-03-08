package com.cn.jvmDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-03-08 15:08
 * @Description: 值传递与引用传递demo
 * @Project_name: java-learn
 */
public class referenceDemo {


    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("a","1");
        List<HashMap> list = new ArrayList<>();
        list.add(map);
        map = null;//引用值Map加入list，再把原map置为空，list内的值不变。说明list里加入的是引用值的副本
        HashMap map1 = list.get(0);
        System.out.println(map1.get("a"));

        int a = 1;
        add(a);
        System.out.println("接口调用完后基本数据的值为：" + a);//调用方法 传入形参 再打印原值，值数据没有发生变化

    }

    public static void add(int tmp){
        tmp++;
        System.out.println("调用接口改变传入的值后结果是：" + tmp);
    }


}
