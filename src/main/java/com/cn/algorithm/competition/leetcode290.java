package com.cn.algorithm.competition;

import java.util.*;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-04-25 10:12
 * @Description: TODO
 * @Project_name: java-learn
 */
public class leetcode290 {

    public static void main(String[] args) {
        int[][] test = new int[][]{{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};
        List<Integer> intersection = intersection(test);

        System.out.println(countLatticePoints(new int[][]{{2, 2, 1}}));
    }

    public static List<Integer> intersection(int[][] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                int cur = nums[i][j];
                map.put(cur,map.getOrDefault(cur, 0) + 1);
            }
        }
        map.forEach( (k,v) -> {
            if(v == sum){
                res.add(k);
            }
        });
        Collections.sort(res);
        return res;
    }


    public static int countLatticePoints(int[][] circles) {
        int ans = 0;
//        for (int i = 0; i < circles.length; i++) {
//            int x = circles[i][0];
//            int y = circles[i][1];
//            int r = circles[i][2];
//            for (int j = 0; j <= 200; j++) {
//                for (int k = 0; k <= 200; k++) {
//                    if((j - x) * (j - x) + (k - y) * (k - y) <= r * r){
//                        ans++;
//                        break;
//                    }
//                }
//            }
//        }

        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 200 ; j++) {
                for (int[] circle : circles) {
                    int x = circle[0];
                    int y = circle[1];
                    int r = circle[2];
                    if ((i - x) * (i - x) + (j - y) * (j - y) <= r * r) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
