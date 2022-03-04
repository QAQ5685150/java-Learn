package com.cn.algorithm;

import java.util.Scanner;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-03-04 10:35
 * @Description: TODO
 * @Project_name: java-learn
 */
public class test {

    public static void main(String[] args) {
        System.out.println(test());
    }
    public static int test() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y[i] = scanner.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length && j != i; j++) {
                if(x[i] < x[j] && y[i] < y[j] || x[i] > x[j] && y[i] > y[j]){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

}
