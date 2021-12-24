package com.cn.algorithm;

import java.util.HashMap;

/**
 * 类名:numberOfBoomerangs_447
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-13 16:59
 **/
public class numberOfBoomerangs_447 {

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,1},{2,2},{3,3},{4,4}};
        System.out.println(numberOfBoomerangs(test));
    }

    public static int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        int ans = 0;
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(i != j){
                    double dis = Math.pow(points[i][0] - points[j][0], 2)
                            + Math.pow(points[i][1] - points[j][1], 2);
                    if(!map.containsKey(dis)){
                        map.put(dis, 1);
                    }else{
                        int n = map.get(dis);
                        ans += 2 * n;
                        map.put(dis, 1+n);
                    }
                }
            }
            map.clear();
        }
        return ans;
    }
}
