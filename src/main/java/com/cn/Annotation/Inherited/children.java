package com.cn.Annotation.Inherited;

/**
 * 类名:children
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-29 11:10
 **/
@subAnn
public class children extends father{


    public children(String name, String age) {
        super(name, age);

    }

    @Override
    public void walk() {
        System.out.println("children "+ super.getName() +" walk……");
    }

    @Override
    public void talk() {
        System.out.println("children "+ super.getName() +" talk……");
    }

    @Override
    public String toString() {
        return "children{" +
                "name='" + super.getName() + '\'' +
                ", age='" + super.getAge() + '\'' +
                '}';
    }
}
