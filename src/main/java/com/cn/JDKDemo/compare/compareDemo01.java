package com.cn.JDKDemo.compare;/**
 * 类名:compareDemo01
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-08 14:30
 **/

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2021-11-08 14:30
 * @Description: comparable接口测试
 * @Project_name: javaTest
 */
public class compareDemo01 {

    public static void main(String[] args) {
        user[] users = new user[]{new user("张三",13),new user("李四",14),new user("李五",4)};
        Arrays.sort(users);
        for (user user : users) {
            //compareTo方法 return this.age - o.age;从小到大排序
            //return this.age - o.age; 从大到小排序
            System.out.println(user);
        }

        int[][] arr = new int[][]{{2,1},{1,2},{2,2}};
        Arrays.sort(arr,new compareArrayInt());
        Arrays.stream(arr).forEach(ints -> {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        });

        System.out.println(longestSubsequence(new int[]{1,2,3,4},1));


    }

    static class compareArrayInt implements Comparator<int[]>{

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }

    public static int longestSubsequence(int[] ints,int dif){
        int[] arr = new int[40001];
        int d = 20000;
        int max = 0;
        for (int anInt : ints) {
            arr[d + anInt] = arr[d + anInt - dif] + 1;
            max = Math.max(max,arr[d + anInt]);
        }
        return max;
    }

}
