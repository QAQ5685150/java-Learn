package com.cn.JdkDemo.reflection.different;

/**
 * @Author: Linxx
 * @Package: com.cn.jdkTest.reflection.different
 * @Time: 2022-08-31 15:54
 * @Description: 使用反射的工厂模式，动态加载类，如果需要新的类，不需要修改代码也可以加载
 **/
public class factoryWithRef {

    public static fruit getInstance(String ClassName){
        fruit f = null;
        try {
            f = (fruit) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
