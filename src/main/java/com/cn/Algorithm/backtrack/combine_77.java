package com.cn.Algorithm.backtrack;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 类名:combine_77
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-19 10:45
 **/
public class combine_77 {
    public static void main(String[] args) {
        for (List<Integer> list : combine(4, 2)) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
        System.out.println(sdf.format(new Date(System.currentTimeMillis())));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<Integer> arr = new ArrayDeque<>();
        process(list, arr, n, k, 1);
        return list;
    }

    public static void process(List<List<Integer>> list, Deque<Integer> arr, int n, int k, int i) {
        if (arr.size() == k) {
            list.add(new ArrayList<>(arr));
            return;
        }
        for (int j = i; j <= n; j++) {
            arr.addLast(j);
            process(list, arr, n, k, i + 1);
            // i + 1就是排列的效果，因为每次进入下一次递归，是在i的进入点开始往下循环遍历的
            arr.removeLast();//回溯法最关键的一步，就是走到了叶子节点要返回了，把上一次加入的结果弹出，就“像是”回到了树状结构上一个节点位置
        }
    }


    /**
     * review
     *
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> review(int n, int k) {
        List<List<Integer>> arr = new ArrayList<>();
        Deque<Integer> list = new ArrayDeque<>();
        _process(arr, list, 1, n, k);
        return arr;
    }

    public static void _process(List<List<Integer>> arr, Deque<Integer> list, int i, int n, int k) {
        if (list.size() == k) {
            arr.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j <= n; j++) {
            list.addLast(j);
            _process(arr, list, i + 1, n, k);
            list.removeLast();
        }
    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combine_review(int n, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        process(deque, 1, n, k);
        return res;
    }

    public static void process(Deque<Integer> queue, int index, int n, int k) {
        if (queue.size() == k) {
            res.add(new ArrayList<>(queue));
            return;
        }
        for (int i = index; i <= n; i++) {
            queue.addLast(i);
            process(queue, i + 1, n, k);
            queue.removeLast();
        }
    }
}
