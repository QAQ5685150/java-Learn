package com.cn.Proxy.staticProxy;

/**
 * 类名:IuserdaoImpl
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-29 13:49
 **/
public class IuserdaoImpl implements Iuserdao{

    private String field;

    public IuserdaoImpl(String field) {
        this.field = field;
    }

    @Override
    public void save(){
        System.out.println(field + " is save");
    }
}
