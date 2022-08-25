package com.cn.jvmDemo;

/**
 * @Author: Linxx
 * @Package: com.cn.jvmDemo
 * @Time: 2022-08-23 14:00
 * @Description: TODO
 **/
public class stackOverFlow {

    public static void main(String[] args) {
        while (true){
            test();
        }
    }

    private static void test(){
        test();
    }
}
