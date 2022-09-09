package com.cn.Algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.backtrack
 * @Time: 2022-07-21 13:49
 * @Description: 二重循环实现一个二个数的递归，如果每多一个属，就需要多增加一层循环，所以有了递归结构和回溯
 **/
public class backtrack_base {

    static List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            result.add(new ArrayList<>());
        }
        for(int i = 1;i < 4;i++){
            for(int j = 1; j < 4; j++){
                result.get(i).add((i + " " + j));
            }
        }
        for (List<String> list : result) {
            for (String integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
