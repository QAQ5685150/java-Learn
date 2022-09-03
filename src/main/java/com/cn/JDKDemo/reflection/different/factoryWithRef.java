package com.cn.JDKDemo.reflection.different;

/**
 * @Author: Linxx
 * @Package: com.cn.jdkTest.reflection.different
 * @Time: 2022-08-31 15:54
 * @Description: ʹ�÷���Ĺ���ģʽ����̬�����࣬�����Ҫ�µ��࣬����Ҫ�޸Ĵ���Ҳ���Լ���
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
