package com.cn.jdkTest.reflection;

import com.cn.pojo.person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 类名:demo02
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-03 15:21
 **/
public class demo02 {

        //创建对象，new  无参，有参！
        //通过指定构造器创建对象！ new person(1L,"获取构造器", 3);
        public static void main(String[] args) throws Exception {

            Class c1 = Class.forName("com.cn.pojo.person");

            System.out.println("==========================================");
            person user1 = (person) c1.newInstance();
            System.out.println(user1);
            System.out.println("调用空参构造创建对象");

            System.out.println("==========================================");
            Constructor declaredConstructor = c1.getDeclaredConstructor(long.class,String.class, int.class);
            person user2 = (person) declaredConstructor.newInstance(1L,"获取构造器", 3);
            System.out.println(user2);
            System.out.println("调用有参构造 注入属性 创建对象");
            System.out.println("==========================================");

            person user3 = (person) c1.newInstance();
            //1. 获得你要操作的方法
            Method setName =c1.getDeclaredMethod("setName",String.class);
            //2. 通过invoke方法执行方法
            setName.invoke(user3,"lhy3");
            System.out.println(user3.getName());
            System.out.println("==========================================");
            person user4  = (person) c1.newInstance();
            Field name = c1.getDeclaredField("name");
            //显示调用setAccessible为true，则可以访问private方法！
            name.setAccessible(true);
            name.set(user4,"lhy4");
            System.out.println(user4.getName());
        }
}
