package com.cn.algorithm.dayCode;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2021-11-08 11:50
 * @Description: TODO
 * @Project_name: javaTest
 */
public class getHint_299 {

    public static void main(String[] args) {
        String secret = "1123";
        String guess = "0111";
        System.out.println(getHint(secret,guess));
    }

    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int[] cntS = new int[10];
        int[] cntG = new int[10];
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                ++cntS[secret.charAt(i) - '0'];
                ++cntG[guess.charAt(i) - '0'];
            }
        }
        int cows = 0;
        for (int i = 0; i < 10; ++i) {
            cows += Math.min(cntS[i], cntG[i]);
        }
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }
}
