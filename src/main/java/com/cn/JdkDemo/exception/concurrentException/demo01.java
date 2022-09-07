package com.cn.JdkDemo.exception.concurrentException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-01-27 13:20
 * @Description: TODO
 * @Project_name: java-learn
 */
public class demo01 {
    public static void main(String[] args) {
        test01();
    }

    /**
     * currentModifyException 测试
     * 出错在这一句：
     * at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)：
     *             if (modCount != expectedModCount)
     *                 throw new ConcurrentModificationException();
     */
    public static void test01(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.forEach( i -> System.out.print(i + " "));
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2)
                list.remove(integer);
        }
    }

    /**
     * currentModifyException 解决办法  用iterator的remove方法
     */
    public static void test02(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.forEach( i -> System.out.print(i + " "));
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2)
                list.remove(integer);
        }
    }
}
