package com.cn.algorithm.array;

/**
 * @Auther: @Ğ¡ÄÔ¸«²»¿É°®
 * @Time: 2022-04-03 10:16
 * @Description: TODO
 * @Project_name: java-learn
 */
public class nextGreatestLetter_744 {

    public static void main(String[] args) {
        char[] test = new char[]{'a','c','c','d','f','j','i','k','m','p','p','r','r'};
        System.out.println(nextGreatestLetter(test, 'p'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;
        int tar = target - 'a';
        if (target >= letters[letters.length - 1]) {
            return letters[0];
        }

        while (l < r){
            int mid = (l + r) / 2;
            int cur = letters[mid] - 'a';
            if(cur > tar){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        System.out.println(letters[l] +":"+l);
        return letters[l];
    }
}
