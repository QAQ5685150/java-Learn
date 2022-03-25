package com.cn.algorithm.math;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-03-25 10:21
 * @Description: TODO
 * @Project_name: java-learn
 */
public class trailingZeroes_172 {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(15));
    }

    /**
     * ��⣺
     *     ������Ŀ����˼��ĩβ�м���0
     *     ����6! = ��1* 2* 3* 4* 5* 6��
     *     ����ֻ��2*5ĩβ����0�����ԾͿ�����ȥ�������� ר�ſ�2 5 �Լ��䱶�� �Ͼ� 4 * 25ĩβҲ��0
     *     ����10�� = ��2*4*5*6*8*10��
     *     ���� 4�ܲ��2*2  10�ܲ��2*5
     *     ����10�� = ��2*��2*2��*5*��2*3��*��2*2*2��*��2*5����
     *     һ��2��һ��5��� �Ͳ���һ��0 ����10��ĩβ2��0
     *
     *     תͷһ�� 2�϶���5�� ����ֻ��5�ĸ���������
     *
     *     ����N=31 31���ܴ�10��5Ϊ[5, 2*5, 3*5, 4*5, 25, 6*5] ���� 25���ܲ�Ϊ 5**2
     *     ���� �����5�ĸ���Ϊ int(31/(5**1)) +  int(31/(5**2))
     *     ���� ֻҪ���Ҹ�һ�� 5**x < n ��x������� Ȼ������ѭ��������
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {
        int count = 0;
        while(n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }


    // ɵ�ϰ�  ģ������ͳ��β�� int��20�ͳ��� Long������100
    public static int trailingZeroes_test(int n) {
        Long ans = Long.valueOf(n);
        while(n > 1){
            ans *= (--n);
        }
        return getNum(ans);
    }

    public static int getNum(Long n){
        int ans = 0;
        while(n > 0){
            if(n % 10 == 0){
                ans++;
                n /= 10;
            }else{
                break;
            }
        }
        return ans;
    }
}