package com.cn.pojo;


import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * 类名:person
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-07-22 16:03
 **/


public class person implements Cloneable{

    private long id;
    private String name;
    private int age;

    @Override
    protected Object clone() throws CloneNotSupportedException {

        return super.clone();
    }


    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public person() {
    }

    public person(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
