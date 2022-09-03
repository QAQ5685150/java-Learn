package com.cn.Algorithm.array;


/**
 * 类名:plusOne_66
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-10-21 17:09
 **/
public class plusOne_66 {

    public static void main(String[] args) {
        int[] test = new int[]{9};
        int[] ints = plusOne(test);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    public static int[] plusOne(int[] digits) {
        int nine = 0;
        int index = digits.length - 1;
        while (index >= 0 && digits[index] == 9){
            nine++;
            index--;
        }
        if(nine == 0){
            digits[digits.length - 1] += 1;
        }else {
            if(nine == digits.length){
                digits = new int[digits.length + 1];
                digits[0] = 1;
                for(int i = 1;i < digits.length; i++){
                    digits[i] = 0;
                }
            }else {
                for(int i = digits.length - 1; i > digits.length - 1 - nine; i--){
                    digits[i] = 0;
                }
                digits[digits.length - nine - 1] += 1;
            }
        }
        return digits;
    }
}
