package com.cn.JdkDemo.reflection.different;

/**
 * @Author: Linxx
 * @Package: com.cn.jdkTest.reflection.different
 * @Time: 2022-08-31 15:55
 * @Description: ��ʹ�÷���Ĺ���ģʽ������ʱ�Ѿ�̬���أ������Ҫ�µ��࣬��Ҫ�޸Ĵ�����¼���
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
