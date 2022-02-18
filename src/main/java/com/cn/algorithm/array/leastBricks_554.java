package com.cn.algorithm.array;

import java.util.*;

/**
 * 类名: leastBricks_554
 * 描述: 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 *
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 * 姓名: @author南风
 * 日期: 2022-02-18 16:45
 **/
public class leastBricks_554 {

    /**
    *功能描述: map保存的<key,value> key是每一次当前位置有没有“空隙”存在，数组中位数上有，表示这里有个空隙，累计第一层该位置有，每一层空隙的位置互不影响都可以在map中get取出来
     * 处理完后就遍历map，把
    *@param args
    *@return void
    **/
    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        Collections.addAll(wall,Arrays.asList(1,2,2,1),Arrays.asList(3,1,2),
                Arrays.asList(1,3,2),Arrays.asList(2,4),Arrays.asList(3,1,2),Arrays.asList(1,3,1,1));
        System.out.println(leastBricks(wall));
    }

    public static int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (Integer integer : wall.get(i)) {
                sum += integer;
                map.put(sum,map.getOrDefault(sum,0) + 1);
            }
            map.remove(sum);
        }
        int ans = n;
        for (Integer integer : map.keySet()) {
            int cur = map.get(integer);
            ans = Math.min(ans,n - cur);
        }
        return ans;
    }
}
