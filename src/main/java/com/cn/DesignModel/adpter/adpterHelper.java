package com.cn.DesignModel.adpter;

/**
 * 类名:adpterHelper
 * 描述:转换器helper
 * 姓名:南风
 * 日期:2021-12-02 15:17
 **/
public class adpterHelper {

    Adapter adapter;

    public adpterHelper(Adapter adapter) {
        this.adapter = adapter;
    }

    public mssages transfer(String s){
        return this.adapter.filter(s);
    }

}
