package com.cn.jdkTest.classes;

/**
 * 类名:innerClass
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-07-30 16:34
 **/
public class innerClass {
    static class staticinner1{
        int i = 11;
        public int value(){
            return i;
        }
    }

    class inner2{
        String s = "this is a inner class";
        public String getS(){
            return s;
        }

        @Override
        public String toString() {
            return "inner2{" +
                    "s='" + s + '\'' +
                    '}';
        }
    }

    public void ship(){
        inner2 inner2 = new inner2();
        staticinner1 s = new staticinner1();
        System.out.println(s.value());
        System.out.println(inner2);
    }



    public static void main(String[] args) {
        int[] test = new int[]{2,7,13,19};
        //System.out.println(nthSuperUglyNumber(10,test));

    }




}
