package com.cn.ThinkingJava.Annotation.database;

/**
 * 类名:Member
 * 描述:实现标注注解，生成要创建的表
 * 姓名:南风
 * 日期:2021-08-19 15:36
 **/
@DBtable(name = "")
public class Member {
    @SQLString(30) String firstName;
    @SQLString(50) String lastName;
    @SQLInteger Integer age;
    @SQLString(value = 30,
            constraints = @Constraints(primaryKey = true))
    String reference;
    static int memberCount;
    public String getReference() { return reference; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    @Override
    public String toString() { return reference; }
    public Integer getAge() { return age; }
}
