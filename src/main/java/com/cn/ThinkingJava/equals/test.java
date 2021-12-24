package com.cn.ThinkingJava.equals;

/**
 * 类名:test
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-19 16:34
 **/
public class test implements testFactory{
    public int i;



    public test(int i){
        this.i = i;
    }

    public void testall(testFactory testFactory){
        test t1 = testFactory.make(1);//这里相当于掉用自己！ 因为调用的时候传入了一个lambda表达式，返回的是一个new test对象的构造！！
        test t2 = testFactory.make(2);//这就相当于每个 make（）函数里的属性是 lambde的 i，被testFactory传入调用make
        test t3 = this.make(3);//使用实现的方法用this调用 new的对象值为空，因为并没有使用testFactory传入的对象，
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }

    @Override
    public test make(int i) {
        return null;
    }

    @Override
    public String toString() {
        return "test{" +
                "i=" + i +
                '}';
    }

    public static void main(String[] args) {
        test t = new test(3);
        t.testall((i)->new test(i));

        System.out.println("此电脑cpu核数：" + Runtime.getRuntime().availableProcessors());
    }
}
