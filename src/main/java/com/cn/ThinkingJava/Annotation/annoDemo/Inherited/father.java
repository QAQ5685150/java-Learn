package com.cn.ThinkingJava.Annotation.annoDemo.Inherited;

/**
 * 类名:fathre
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-29 11:09
 **/
@superAnn
public class father {

    @superAnn
    private String name;

    private String age;

    public father(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void walk(){
        System.out.println("father "+ name +" walk……");
    }

    public void talk(){
        System.out.println("father "+ name + " talk……");
    }

    @Override
    public String toString() {
        return "father{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
