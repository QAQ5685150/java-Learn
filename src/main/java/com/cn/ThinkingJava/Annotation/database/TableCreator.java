package com.cn.ThinkingJava.Annotation.database;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名:TableCreator
 * 描述:创建表处理器
 * 姓名:南风
 * 日期:2021-08-19 15:45
 **/
public class TableCreator {
    public static void main(String[] args) throws Exception {
        Class<?> cl = TableCreator.class.getClass().getClassLoader().loadClass("com.cn.ThinkingJava.Annotation.database.Member");
        String className = cl.getName();
            DBtable dbTable = cl.getAnnotation(DBtable.class);
            if (dbTable == null) {
                System.out.println(
                        "No DBTable annotations in class " +
                                className);
            }
            String tableName = dbTable.name();
            // If the name is empty, use the Class name:
            if (tableName.length() < 1)
                tableName = cl.getName().toUpperCase();
            List<String> columnDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName = null;
                Annotation[] anns =
                        field.getDeclaredAnnotations();
                if (anns.length < 1)
                    continue; // Not a db table column
                if (anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) anns[0];
                    // Use field name if name not specified
                    if (sInt.name().length() < 1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sInt.name();
                    columnDefs.add(columnName + " INT" +
                            getConstraints(sInt.constraints()));
                }
                if (anns[0] instanceof SQLString) {
                    SQLString sString = (SQLString) anns[0];
                    // Use field name if name not specified.
                    if (sString.name().length() < 1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sString.name();
                    columnDefs.add(columnName + " VARCHAR(" +
                            sString.value() + ")" +
                            getConstraints(sString.constraints()));
                }
                StringBuilder createCommand = new StringBuilder(
                        "CREATE TABLE " + tableName + "(");
                for (String columnDef : columnDefs)
                    createCommand.append(
                            "\n " + columnDef + ",");
                // Remove trailing comma
                String tableCreate = createCommand.substring(
                        0, createCommand.length() - 1) + ");";
                System.out.println("Table Creation SQL for " +
                        className + " is:\n" + tableCreate);
            }
        }


    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNull())
            constraints += " NOT NULL";
        if (con.primaryKey())
            constraints += " PRIMARY KEY";
        if (con.unique())
            constraints += " UNIQUE";
        return constraints;
    }
}

