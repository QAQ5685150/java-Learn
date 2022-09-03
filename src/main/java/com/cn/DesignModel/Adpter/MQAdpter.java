package com.cn.DesignModel.Adpter;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 类名:Adpter
 * 描述:消息适配器
 * 姓名:南风
 * 日期:2021-12-01 17:28
 **/
public class MQAdpter implements Adapter{

    //转换规则
    static Map<String, String> map = new HashMap<>();

    static {
        map.put("id","uid");
        map.put("date","newdate");
        map.put("content","desc");
    }

    @Override
    public mssages filter(String jsonStr) {
        mssages ms = null;
        try {
            ms = filter(JSON.parseObject(jsonStr, Map.class), map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ms;
    }

    public mssages filter(Map objMap,Map<String, String> link)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        mssages m = new mssages();
        for (String key : link.keySet()) {
            Object value = objMap.get(link.get(key));
            if(key.equals("id")){
                reflactLong("set" + key.substring(0,1).toUpperCase() + key.substring(1),Long.class,m,Long.valueOf(value.toString()));
                continue;
            }

            reflact("set" + key.substring(0,1).toUpperCase() + key.substring(1),String.class,m,value.toString());
        }
        return m;
    }

    public static void reflact(String s,Class clazz,mssages m,Object value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        mssages.class.getMethod(s,clazz).invoke(m,value);
    }

    public static void reflactLong(String s,Class clazz,mssages m,Long value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        mssages.class.getMethod(s,clazz).invoke(m,value);
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        account a = new account(2L,new Date(),"test","this is a test");
        String s = a.toString();
        System.out.println(s);

        adpterHelper ad = new adpterHelper(new MQAdpter());
        mssages transfer = ad.transfer(s);

        System.out.println("转换前：" + a.toString());
        System.out.println("===================");
        System.out.println("转换后:" + transfer.toString());

    }
}
