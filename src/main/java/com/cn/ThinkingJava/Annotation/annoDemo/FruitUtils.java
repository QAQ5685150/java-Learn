package com.cn.ThinkingJava.Annotation.annoDemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 类名:FruitUtils
 * 描述:2021-08-17:添加FruitUtils传入class解析注解内容信息的功能
 *     2021-08-18：继承Fruits抽象类，实验子类继承抽象类，使用抽象类成员变量和方法，抽象功能，子类实现功能，调用默认方法
 * 姓名:南风
 * 日期:2021-08-17 11:47
 **/
public class FruitUtils extends Fruits{

    private Class<?> clazz;

    public FruitUtils(){
        super(19,1);
    }

    public FruitUtils(Class<?> clazz,Integer price,Integer pack){
        super(price,pack);
        this.clazz = clazz;
        this.show();
        super.show();
    }

    public void getInfo(Class<?> clazz) throws InvocationTargetException, IllegalAccessException {

        Annotation[] Annotations = clazz.getDeclaredAnnotations();
        Method[] methods = Annotations.getClass().getMethods();
        Method[] methods1 = clazz.getMethods();
        for (Method method : methods1) {
            System.out.println(method.getName());
        }

        Annotation[] annotations = clazz.getAnnotations();
        System.out.println(annotations.length);

        Field[] declaredFields = clazz.getDeclaredFields();//获取成员变量上有注释的注释中的信息
        for (Field declaredField : declaredFields) {
            if(declaredField.isAnnotationPresent(FruitName.class)){
                FruitName annotation = declaredField.getAnnotation(FruitName.class);
                System.out.println(annotation.value());
            }
            if(declaredField.isAnnotationPresent(FruitColor.class)){
                FruitColor annotation = declaredField.getAnnotation(FruitColor.class);
                System.out.println(annotation.fruitColor());
            }
            if(declaredField.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider = declaredField.getAnnotation(FruitProvider.class);
                String strFruitProvicer="供应商编号："+fruitProvider.id()+" 供应商名称："+fruitProvider.name()+" 供应商地址："+fruitProvider.address();
                System.out.println(strFruitProvicer);
            }
        }
    }

    public void testThis() throws Exception {
        this.getInfo(clazz);
    }

    @Override
    public void sellFruits() {
        super.show();
        System.out.println("final fruit price = " + (super.price+super.pack));
    }
}

class test{
    public static void main(String[] args) throws Exception {
        FruitUtils fu = new FruitUtils();
        //fu.getInfo(Apple.class);
        //getInfo（）类传入的是一个类，在里面获取了使用我们自定义注解的信息，通过@注解获得在注解上标注的信息在运行时获取

        FruitUtils fu1 = new FruitUtils(Apple.class,14,1);
        //fu1.testThis();
        fu1.sellFruits();
    }
}
