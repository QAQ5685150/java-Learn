package com.cn.JDKDemo.streamAPI.linkedDemo;

import com.cn.Pojo.person;

/**
 * @class: paramTest
 * @description: 模拟swagger配置全局参数 ParameterBuilder 的构造对象方式
 * @author: 南风
 * @date: 2021-12-10 10:37
 **/
public class paramTest {

    private String name;

    private String password;

    private String model;

    private String header;

    private person person;

    public paramTest name(String name){
        this.name = name;
        return this;
    }

    public paramTest password(String password){
        this.password = password;
        return this;
    }

    public paramTest model(String model){
        this.model = model;
        return this;
    }

    public paramTest header(String header){
        this.header = header;
        return this;
    }

    public paramTest person(person person){
        this.person = person;
        return this;
    }

    @Override
    public String toString() {
        return "paramTest{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", model='" + model + '\'' +
                ", header='" + header + '\'' +
                ", person=" + person +
                '}';
    }

    public static void main(String[] args) {
        paramTest pt1 = new paramTest();
              pt1.name("test")
                .password("123456")
                .model("linked")
                .header("demo")
                .person(new person());
        paramTest pt2 = new paramTest();
        System.out.println(pt1.toString());
        System.out.println(pt2.toString());
    }
}
