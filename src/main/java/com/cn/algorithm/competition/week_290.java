package com.cn.algorithm.competition;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-06-10 11:14
 * @Description: TODO
 * @Project_name: java-learn
 */
public class week_290 {

    public static void main(String[] args) {
        System.out.println(digitSum("11111222223",3));
    }

    public static String digitSum(String s, int k) {
        while(s.length() > k){
            String tmp = "";
            for(int i = 0; i < s.length(); i+=k){
                int cur = 0;
                for(int j = i;j < k + i && j < s.length(); j++){
                    cur += s.charAt(j) - '0';
                }
                tmp += String.valueOf(cur);
            }
            s = tmp;
        }
        return s;
    }
}
