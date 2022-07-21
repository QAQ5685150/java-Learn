package com.cn.algorithm.backtrack;

import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 类名:combine_77
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-08-19 10:45
 **/
public class combine_77 {
    public static void main(String[] args) {
        for (List<Integer> list : combine(4, 3)) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<Integer> arr = new ArrayDeque<>();
        process(list,arr,n,k,1);
        return list;
    }

    public static void process(List<List<Integer>> list,Deque<Integer> arr,int n,int k,int i){
        if(arr.size() == k){
            list.add(new ArrayList<>(arr));
            return;
        }
        for(int j = i;j <= n;j++){
            arr.addLast(j);
            process(list,arr,n,k,j + 1);//index变化位传入for循环的参数j,进入循环以后，选取下一个位置的数字放入arr，就不会产生重复数
            //process(list,arr,n,k,i+1);//index变化位传入其实形参i，如果传入的是i + 1 就会产生重复，
            arr.removeLast();//回溯法最关键的一步，就是走到了叶子节点要返回了，把上一次加入的结果弹出，就“像是”回到了树状结构上一个节点位置
        }
    }


    /**
     *      review
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> review(int n, int k) {
        List<List<Integer>> arr = new ArrayList<>();
        Deque<Integer> list = new ArrayDeque<>();
        _process(arr,list,1,n,k);
        return arr;
    }

    public static void _process(List<List<Integer>> arr, Deque<Integer> list, int i, int n, int k){
        if(list.size() == k){
            arr.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j <= n; j++) {
            list.addLast(j);
            _process(arr,list,i + 1,n,k);
            list.removeLast();
        }
    }
}
