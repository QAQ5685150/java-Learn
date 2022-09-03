package com.cn.Algorithm.array.hash;

import java.util.HashMap;

/**
 * 类名:numberOfBoomerangs_447
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-13 16:59
 **/
public class numberOfBoomerangs_447 {

    /**
    *功能描述:给定平面上n 对 互不相同 的点points ，其中 points[i] = [xi, yi] 。
     *
     * 回旋镖 是由点(i, j, k) 表示的元组 ，其中i和j之间的距离和i和k之间的欧式距离相等（需要考虑元组的顺序）。
     *
     * 返回平面上所有回旋镖的数量。
    **/
    public static void main(String[] args) {
        int[][] test = new int[][]{{1,1},{2,2},{3,3},{4,4}};
        System.out.println(numberOfBoomerangs(test));
    }

    /**
    *功能描述: 枚举 + 哈希表
    *@param points
    *@return int
    **/
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
