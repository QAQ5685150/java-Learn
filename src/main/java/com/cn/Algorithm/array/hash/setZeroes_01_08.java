package com.cn.Algorithm.array.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.array.hash
 * @Time: 2022-09-30 11:08
 * @Description: 面试题 01.08. 零矩阵
 **/
public class setZeroes_01_08 {

    /**
     * 两次遍历 第一次遍历统计哪个位置上的数为0
     * 第二次遍历把统计表里的坐标位置行列置为0
     * 不能用dfs边遍历边修改，修改为0后再继续遍历，不为0的地方也会被修改
     * 还想过修改成一个不相干的数，第二次遍历再修改回来，但是这样相同列为0的话 后面的0就遍历不到了
     * 所以用记录的方法，记录完再遍历一次
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int col = matrix.length;
        int row = matrix[0].length;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                if(matrix[i][j] == 0){
                    list.add(new int[]{i,j});
                }
            }
        }
        for(int[] label: list){
            set(matrix, label[0], label[1]);
        }
    }

    public void set(int[][] matrix, int i, int j){
        for(int k = 0; k< matrix[0].length; k++){
            matrix[i][k] = 0;
        }
        for(int k = 0; k< matrix.length; k++){
            matrix[k][j] = 0;
        }
    }
}
