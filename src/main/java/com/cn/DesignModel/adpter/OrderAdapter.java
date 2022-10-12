package com.cn.DesignModel.adpter;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 类名:OrderAdapter
 * 描述:转换器实现类
 * 姓名:南风
 * 日期:2021-12-02 15:23
 **/
public class OrderAdapter implements Adapter{

    static Map<String, String> map = new HashMap<>();

    //加载转换规则
    static {
        //map.put("key - mssage field","value - transfered bean field");
    }

    @Override
    public mssages filter(String jsonStr) {
        mssages ms = null;
        try {
            ms =  filter(JSON.parseObject(jsonStr,Map.class),map);
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

            mssages.class.getMethod(
                    "set" + key.substring(0,1).toUpperCase() + key.substring(1),String.class)
                    .invoke(m,value.toString());
        }
        return m;
    }
}
