package com.cn.Utils;

import com.cn.Pojo.user;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Linxx
 * @Package: com.samples.vehicles.util
 * @Time: 2022-11-17 13:35
 * @Description: 数据库建表语句工具类
 **/
public class CreatTableUtil {

        //支持map通过K-v获取值
        private static List getClassInfo(Object o) {

            Field[] fields = o.getClass().getDeclaredFields();

            String[] fieldNames = new String[fields.length];

            List list = new ArrayList();

            Map infoMap = null;

            for (int i = 0; i < fieldNames.length; i++) {
                infoMap = new HashMap();

                infoMap.put("type", fields[i].getType().toString());

                infoMap.put("name", fields[i].getName());

                list.add(infoMap);
            }
            return list;

        }
        //获取类的属性名称
        private static String[] getClassdatatype(Object o){
            Field[] fields = o.getClass().getDeclaredFields();

            String[] fieldtypes = new String[fields.length];

            for (int i = 0; i < fieldtypes.length; i++) {
                fieldtypes[i] = fields[i].getType().toString();
            }
            return fieldtypes;
        }

        //获取类的属性类型
        private static  String[] getClassdataName(Object o){
            Field[] fields = o.getClass().getDeclaredFields();

            String[] fieldNames = new String[fields.length];

            for (int i = 0; i < fieldNames.length; i++) {
                fieldNames[i] = fields[i].getName();
            }
            return fieldNames;
        }

        //自动生成sql语句
        public static String createTablesql(String tablename,Object obs){
            //判断是否符合规范
            if(tablename.isEmpty()||obs==null){
                return "参数不完整";
            }
            //获得类的属性名称
            String[] name = getClassdataName(obs);
            String[] type = getClassdatatype(obs);
            String sql ="create table if not exists "+tablename+"(";
            //转换数据类型
            for(int i = 0;i<type.length;i++){
                name[i] = name[i].toLowerCase();
                if(type[i].equals("class java.lang.String")){
                    type[i] = "varchar(255)";
                }
                if(type[i].equals("class java.lang.Integer")){
                    type[i] = "int(4)";
                }
                if(type[i].equals("class java.sql.Timestamp")){
                    type[i] = "timestamp(0)";
                }
            }
            for(int i = 0;i<name.length-1;i++){
                sql=sql+name[i]+" "+type[i]+",";
            }
            sql=sql+name[name.length-1]+" "+type[name.length-1]+")";

            return sql;
        }


    public static void main(String[] args) {
        System.out.println(createTablesql("province_vehicle", new user()));
    }

}
