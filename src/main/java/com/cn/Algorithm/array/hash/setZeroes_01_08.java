package com.cn.Algorithm.array.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Linxx
 * @Package: com.cn.Algorithm.array.hash
 * @Time: 2022-09-30 11:08
 * @Description: ������ 01.08. �����
 **/
public class setZeroes_01_08 {

    /**
     * ���α��� ��һ�α���ͳ���ĸ�λ���ϵ���Ϊ0
     * �ڶ��α�����ͳ�Ʊ��������λ��������Ϊ0
     * ������dfs�߱������޸ģ��޸�Ϊ0���ټ�����������Ϊ0�ĵط�Ҳ�ᱻ�޸�
     * ������޸ĳ�һ������ɵ������ڶ��α������޸Ļ���������������ͬ��Ϊ0�Ļ� �����0�ͱ���������
     * �����ü�¼�ķ�������¼���ٱ���һ��
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
