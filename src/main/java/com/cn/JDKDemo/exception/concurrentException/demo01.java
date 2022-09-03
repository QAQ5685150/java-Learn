package com.cn.JDKDemo.exception.concurrentException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-01-27 13:20
 * @Description: TODO
 * @Project_name: java-learn
 */
public class demo01 {
    public static void main(String[] args) {
        test01();
    }

    /**
     * currentModifyException ����
     * ��������һ�䣺
     * at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)��
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
     * currentModifyException ����취  ��iterator��remove����
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
