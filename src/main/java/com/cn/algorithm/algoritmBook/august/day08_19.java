package com.cn.algorithm.algoritmBook.august;

import com.cn.algorithm.util.printUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.algoritmBook.august
 * @Time: 2022-08-19 9:25
 * @Description: TODO
 **/
public class day08_19 {

    private int num;

    public day08_19(int i) {
        this.num = i;
    }


    /**
     * 找规律的题 搞成模拟了……
     * @throws IOException
     */
    public static void triangle() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int n = Integer.parseInt(line);
        int[][] arr = new int[n][2 * n - 1];
        arr[0][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 2 * (i + 1) - 1; j++) {
                if(j == 0 || j == (2 * (i + 1) - 1)) arr[i][j] = 1;
                else if(j == 1) arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                else {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j + 1];
                }
            }
        }
        printUtils.printArray(arr);
    }

}
