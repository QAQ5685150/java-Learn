package com.cn.Algorithm.math;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-03-25 11:02
 * @Description: ������ֽ����ԣ����ҳ����㷨�⣬�޼�һ�㷨���������Ȼû���������������������Լ���������Լ�һ���ơ���
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
     * ���Լ�������д�İ汾����������һ��0 ��123  ->  3210��
     * ԭ�����ҵ�ansÿ��
     * @param n
     */
    public static void reverseNum_test(int n){
        int ans = 0;
        while (n > 0){
            ans *= 10;
            ans += n % 10;
            //ans *= 10; ������ͷ��������ǲ�һ���ģ���������һ��0 ��Ϊ�Ǽ����ٳ�  ��һ�ν����������30 ѭ�����ξ���3210
            n /= 10;
        }
        System.out.println(ans);
    }
}
