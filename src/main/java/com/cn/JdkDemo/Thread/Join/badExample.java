package com.cn.JdkDemo.Thread.Join;

/**
 * @Author: Linxx
 * @Package: com.cn.JdkDemo.Thread.Join
 * @Time: 2022-10-27 9:43
 * @Description: TODO
 **/
public class badExample {
    Integer total = 9;

    public static void main(String[] args) {

    }

    class takeApple{
        monkey m;
        takeApple(monkey m){
            this.m = m;
        }
        public void take(){
            while (true){
                synchronized (total){
                    if(total - m.count <= 0){
                        total.notify();
                        break;
                    }
                }
                System.out.println(Thread.currentThread().getName() + " get apple ,left " + total);
            }

        }

    }

    class monkey{
        int count;
        monkey(int count){
            this.count = count;
        }
    }
}
