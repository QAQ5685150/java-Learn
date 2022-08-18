package com.cn.algorithm.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.array
 * @Time: 2022-08-15 16:05
 * @Description: TODO
 **/
public class findDisappearedNumbers_447 {

    public static void main(String[] args) {
        for (Integer disappearedNumber : findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1})) {
            System.out.print(disappearedNumber + " ");
        }
    }

    public static List<Integer> findDisappearedNumbers(int[] arr){
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        for (int i : arr) {
            int hash = (i - 1) % n; //这里必须余数组长度，因为前面计算的hash值可能是后面的数组，在后面加上了n 不余就会arrayOutOfBound
            arr[hash] += n;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= n){
                res.add(i + 1);
            }
        }
        return res;
    }
}
