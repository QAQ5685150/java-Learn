package com.cn.algorithm.backtrack;

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
        combine(4,2);

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
           // process(list,arr,n,k,j+1);//index变化位传入for循环的参数j
            process(list,arr,n,k,i+1);//index变化位传入其实形参i
            arr.removeLast();
        }
    }
}
