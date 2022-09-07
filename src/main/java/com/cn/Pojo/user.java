package com.cn.Pojo;



/**
 * 类名:user
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-08 14:28
 **/
public class user implements Comparable<user> {

    private String name;

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private Integer age;

    public user() {
    }

    public user(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    @Override
    public int compareTo(user o) {
        //return this.age - o.age;
        return o.age - this.age;
    }
}
