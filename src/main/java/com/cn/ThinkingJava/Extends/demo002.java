package com.cn.ThinkingJava.Extends;

/**
 * 类名:demo02
 * 描述:父类启动时把子类继承的方法修改的对象属性整合到配置类
 * 姓名:南风
 * 日期:2021-09-18 10:27
 **/
public class demo002 {

    public static void main(String[] args) {
        father f = new father("hank",35);
        children c = new children("tony",6,"pikachu");
        family family = new family(f,c,c);
        family.checkConfig();
        for (int i = 0; i < 20; i++) {
            System.out.println((int)Math.pow(3,i));
        }
    }
}

class family{
    public father father;
    public children children;
    public toy toy;

    public family(com.cn.ThinkingJava.Extends.father father, com.cn.ThinkingJava.Extends.children children, com.cn.ThinkingJava.Extends.toy toy) {
        this.father = father;
        this.children = children;
        this.toy = toy;
    }

    public void checkConfig(){
        //father.config(this.children);
        children.getToy();
    }
}

interface toy{

    public void getToy();
}

class father{

    public String name;
    public Integer age;
    public boolean isBuy;

    public father() {
    }
    public father(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void config(toy toy){
        this.isBuy = true;
        toy.getToy();
    }

}
class children extends father implements toy{

    public String childName;
    public Integer childAge;
    public String wanted;

    public children(String childName, Integer childAge,String wanted) {
        super();
        this.childName = childName;
        this.childAge = childAge;
        this.wanted = wanted;
    }

    @Override
    public void getToy() {
        System.out.println(childName +" who is "+ childAge + " buy a toy " + wanted);
    }
}