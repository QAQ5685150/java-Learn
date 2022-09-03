package com.cn.Algorithm.array;

import java.util.*;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-04-01 10:25
 * @Description: TODO
 * @Project_name: java-learn
 */
public class canReorderDoubled_954 {

    public static void main(String[] args) {
        int[] test = new int[]{2,2,4,6,2,4,4,8,12,10};
        System.out.println(canReorderDoubled03(test));
    }

    /**
     *  80% 样例[2,4,0,0,8,1]错误 12 48是可以的 但我的程序会每个都找一遍，map的value记得又是出现次数会出现问题
     * @param arr
     * @return
     */
    public static boolean canReorderDoubled(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            if(map.containsKey(cur * 2)){
                map.put(cur * 2,map.get(cur * 2) - 1);
                map.put(cur,map.get(cur) - 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if(next.getValue() != 0 && next.getKey() != 0){
                return false;
            }
        }
        return true;
    }

    public static boolean canReorderDoubled02(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list,(a,b) -> Math.abs(a) - Math.abs(b));
        boolean[] isVisited = new boolean[arr.length];
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if(!isVisited[i]){
                int cur = list.get(i);
                for (int j = i + 1; j < arr.length; j++) {
                    if(!isVisited[j] && cur * 2 == list.get(j)){
                        isVisited[i] = true;
                        isVisited[j] = true;
                        ans += 2;
                        break;
                    }
                }
            }
        }
        return ans == arr.length;
    }

    /**
     * 官方题解，hash表法。我第一次想的也是这个方法，有些地方还是没搞明白
     * @param arr
     * @return
     */
    public static boolean canReorderDoubled03(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : arr) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        if (cnt.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }

        List<Integer> vals = new ArrayList<Integer>();
        for (int x : cnt.keySet()) {
            vals.add(x);
        }
        Collections.sort(vals, (a, b) -> Math.abs(a) - Math.abs(b));

        for (int x : vals) {
            if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) { // 无法找到足够的 2x 与 x 配对
                return false;
            }
            cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
        }
        return true;
    }
}
