package com.cn.jvmDemo;

import java.util.ArrayList;

/**
 * @Author: Linxx
 * @Package: com.cn.jvmDemo
 * @Time: 2022-08-23 13:42
 * @Description: TODO
 **/
public class oomHeapSpace {

    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        while (true){
            arrayList.add(new Object());
        }
    }
}
