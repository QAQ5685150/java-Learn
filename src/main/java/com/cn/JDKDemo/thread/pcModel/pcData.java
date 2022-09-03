package com.cn.JDKDemo.thread.pcModel;

/**
 * 类名:pcData
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-16 15:26
 **/
public class pcData {

    private final int intData;

    public pcData(int d){
        intData = d;
    }
    public pcData(String d){
        intData = Integer.valueOf(d);
    }
    public int getData(){
        return intData;
    }
    @Override
    public String toString(){
        return "data:"+intData;
    }
}
