package com.cn.algorithm.backtrack;

import java.util.*;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.backtrack
 * @Time: 2022-08-04 16:36
 * @Description: BM56 有重复项数字的全排列
 **/
public class permuteUnique_BM56 {

    public static void main(String[] args) {

    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        int len = num.length;
        boolean[] visit = new boolean[len];
        ArrayList<Integer> tmp = new ArrayList<>();
        process(num,tmp,visit);
        return res;
    }

    public void process(int[] num, ArrayList<Integer> tmp, boolean[] visit){
        if(num.length == tmp.size()){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = 0; i < num.length; i++){
            if(visit[i] == true) continue;
            if(i > 0 && num[i] == num[i - 1] && !visit[i - 1]) continue;
            visit[i] = true;
            tmp.add(num[i]);
            process(num,tmp,visit);
            visit[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
