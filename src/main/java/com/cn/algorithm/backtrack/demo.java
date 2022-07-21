package com.cn.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.backtrack
 * @Time: 2022-07-21 13:49
 * @Description: TODO
 **/
public class demo {

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
