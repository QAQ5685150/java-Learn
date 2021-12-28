package com.cn.ThinkingJava.Annotation.annoDemo;

/**
 * 类名:test01
 * 描述:自定义类使用注解，模拟在运行时获取注解类标注的信息
 * 姓名:南风
 * 日期:2021-08-17 11:32
 **/
public final class Apple {
    @FruitName("红富士")
    private String appleName;

    @FruitColor(fruitColor = FruitColor.Color.GREEN)
    private String appleColor;

    @FruitProvider(id=1,name="陕西红富士集团",address="陕西省西安市延安路89号红富士大厦")
    private String appleProvider;

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }
    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }
    public String getAppleName() {
        return appleName;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
    public String getAppleProvider() {
        return appleProvider;
    }

    public void displayName(){
        System.out.println("水果的名字是：苹果");
    }

    public static void nnn(){

    }
}

class app{
    public static void main(String[] args) {

    }
}
