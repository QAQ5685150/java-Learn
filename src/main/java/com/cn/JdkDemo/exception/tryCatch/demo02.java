package com.cn.JdkDemo.exception.tryCatch;

/**
 * @Author: Linxx
 * @Package: com.cn.JdkDemo.exception.tryCatch
 * @Time: 2022-11-30 14:02
 * @Description: try-catch-finally
 **/
public class demo02 {

    public static void main(String[] args) {
        System.out.println("start i = 0");
        System.out.println("after return :" + tcf());
    }

    public static Integer tcf(){
        int i = 0;
        try {
            i++;
            System.out.println("after try ++ :" + i);
            i /= 0;
            return i;
        }catch (Exception e){
            i++;
            System.out.println("after catch ++ :" + i);
            return i;
        }finally {
            i++;
            System.out.println("after finally ++ :" + i);
            return i;
        }
    }
}
