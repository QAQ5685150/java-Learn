package com.cn.Algorithm.array;

import java.util.*;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-06-10 11:42
 * @Description: TODO
 * @Project_name: java-learn
 */
public class topKFrequent_347 {

    public static void main(String[] args) {
        int[] test = new int[]{1,1,1,2,2,3};
        for (int i : topKFrequent2(test, 2)) {
            System.out.println(i);
        }
    }

    /**
     * 优先队列，插入直接排序
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];//优先队列排序规则，b-a为true 排序按从大到小排列
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            queue.offer(new int[]{key,value});
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }

    /**
     * topK统计 TreeMap排序
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries,comparator);
        int[] ans = new int[k];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            if(index >= k){
                break;
            }
            ans[index++] = entry.getValue();
        }
        return ans;
    }

}
