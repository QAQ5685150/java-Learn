package com.cn.jdkTest.reflection.different;

/**
 * @Author: Linxx
 * @Package: com.cn.jdkTest.reflection.different
 * @Time: 2022-08-31 15:55
 * @Description: 不使用反射的工厂模式，编译时已静态加载，如果需要新的类，需要修改代码从新加载
 **/
public class factoryWithoutRef {

    public static fruit getInstance(String ClassName){
        fruit f = null;
        if("Apple".equals(ClassName)){
            f = new Apple();
        }else if("Banana".equals(ClassName)){
            f = new Banana();
        }
        return f;
    }

}
