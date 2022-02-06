package com.cn.algorithm.math;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-02-05 12:32
 * @Description: �����������1-5 ʵ�����������1-7 �м�����chap1
 * @Project_name: java-learn
 */
public class rand5To7 {

    public static int rand1To5(){
        return (int) ((Math.random() * 5) + 1);
    }

    public static int rand1To7(){
        int num = 0;
        do {
            num = (rand1To5() - 1) * 5 + rand1To5() - 1;
        }while (num > 20);
        return num % 7 + 1;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i : randTest(100,8)) {
            System.out.print(i + " ");
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("����ʱ�䣺" + (end - start) + " us");
    }

    public static int[] randTest(int times,int length){
        int index = 0;
        int[] arr = new int[length + 1];
        for (int i = 0; i < times; i++) {
            int sum = 0;
            for (int j = 0; j < times; j++) {
                sum += rand1To7();
            }
            index = sum / 100;
            arr[index]++;
        }
        return arr;
    }
}
