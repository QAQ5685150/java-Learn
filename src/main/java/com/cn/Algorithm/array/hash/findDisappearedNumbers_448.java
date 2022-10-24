package com.cn.Algorithm.array.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.array
 * @Time: 2022-08-15 16:05
 * @Description: TODO
 **/
public class findDisappearedNumbers_448 {

    public static void main(String[] args) {
        for (Integer disappearedNumber : findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1})) {
            System.out.print(disappearedNumber + " ");
        }
    }

    public static List<Integer> findDisappearedNumbers(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        for (int i : arr) {
            int hash = (i - 1) % n; //取余是因为给的数字有可能超出范围，区余数就不会超出数组范围了
            arr[hash] += n;//直接写原数组，不浪费空间，判断也可以直接在原数组上，范围内没出现的数字计算的hash无法出现，就找到了没出现的数
            //不优雅的写法可能直接就用map计数，再遍历map，也可以实现但还有更好的解决方法
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
