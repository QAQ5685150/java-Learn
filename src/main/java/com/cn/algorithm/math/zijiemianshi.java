package com.cn.algorithm.math;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-03-25 11:02
 * @Description: 昨天的字节面试，给我出的算法题，巨简单一算法，我他妈居然没做出来…………服了我自己，好想抽自己一巴掌……
 * @Project_name: java-learn
 */
public class zijiemianshi {

    public static void main(String[] args) {
           reverseNum_test(123);
    }

    public static void reverseNum(int n){
        int ans = 0;
        while (n > 0){
            ans = ans * 10 + n % 10;
            n /= 10;
        }
        System.out.println(ans);
    }

    /**
     * 我自己不看答案写的版本，最后会多出来一个0 （123  ->  3210）
     * 原因是我的ans每次
     * @param n
     */
    public static void reverseNum_test(int n){
        int ans = 0;
        while (n > 0){
            ans *= 10;
            ans += n % 10;
            //ans *= 10; 放上面和放下面结果是不一样的，放下面会多一个0 因为是加完再乘  第一次结果出来就是30 循环三次就是3210
            n /= 10;
        }
        System.out.println(ans);
    }
}
