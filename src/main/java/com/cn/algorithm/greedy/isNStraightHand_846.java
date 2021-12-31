package com.cn.algorithm.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 类名: isNStraightHand_846
 * 描述: TODO
 * 姓名: @author南风
 * 日期: 2021-12-30 14:03
 **/
public class isNStraightHand_846 {

    public static void main(String[] args) {
        int[] hand = new int[]{1,2,3,6,2,3,4,7,5};
        int groupSize = 3;
        //System.out.println(isNStraightHand(hand,groupSize));
        System.out.println(isNStraightHand_1(hand,groupSize));
        System.out.println(isNStraightHand_2(hand,groupSize));
    }

    /**
    *功能描述:test
    *@param hand 手牌列表
    *@param groupSize 分组大小
    *@return boolean
    **/
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
        Arrays.sort(hand);

        for (int i = 0; i < hand.length - groupSize; i+=groupSize) {
            int tmp = hand[i + 1] - hand[i];
            for (int j = i + 1; j < groupSize; j++) {
                if(hand[j] - hand[i] != tmp) return false;
            }
        }
        return true;
    }

    /**
     *功能描述: 哈希表法 test
     *@param hand 手牌列表
     *@param groupSize 分组大小
     *@return boolean
     **/
    public static boolean isNStraightHand_1(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
        Arrays.sort(hand);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : hand) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }

        for (int i : hand) {
            if(map.containsKey(i)){
                for (int j = 0; j < groupSize; j++) {
                    int tmp = i + j;
                    if(!map.containsKey(tmp)){
                        return false;
                    }
                    map.put(tmp,map.get(tmp) - 1);
                    if(map.get(tmp) == 0){
                        map.remove(tmp);
                    }
                }
            }
        }
        return true;
    }

    /**
     *功能描述: 哈希表法
     *@param hand 手牌列表
     *@param groupSize 分组大小
     *@return boolean
     **/
    public static boolean isNStraightHand_2(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : hand) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        for (int x : hand) {
            if (!cnt.containsKey(x)) {
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                int num = x + j;
                //如果不存在“分组”后最小字符 返回false
                if (!cnt.containsKey(num)) {
                    return false;
                }
                //有重复的才遍历，如果一个数存在多次，就意味着在划分的多个数组中存在，对“另一个”排序后的数组，把同组的统计过后移除hash表
                //对于当前组的数，也是一样的逻辑，把出现过在数组中的数出现次数减一
                //这个统计出现次数，对出现过的减一这种思路太妙了，我就是这块没想到怎么解，想了半天想不出来
                cnt.put(num, cnt.get(num) - 1);
                if (cnt.get(num) == 0) {
                    cnt.remove(num);
                }
            }
        }
        return true;
    }
}
