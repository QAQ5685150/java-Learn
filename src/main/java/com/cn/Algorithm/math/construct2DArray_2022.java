package com.cn.Algorithm.math;

import com.cn.Algorithm.util.printUtils;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-01-01 22:32
 * @Description: TODO
 * @Project_name: java-learn
 */
public class construct2DArray_2022 {

    /**
     * ����һ���±�� 0��ʼ��һά��������original����������m��n������Ҫʹ��original������Ԫ�ش���һ��m��n�еĶ�ά���顣
     *
     * original���±�� 0�� n - 1���� ���� ����Ԫ�ع��ɶ�ά����ĵ�һ�У��±�� n�� 2 * n - 1������������Ԫ�ع��ɶ�ά����ĵڶ��У��������ơ�
     *
     * ��������������̷���һ��m x n�Ķ�ά���顣����޷����������Ķ�ά���飬���㷵��һ���յĶ�ά���顣
     */
    public static void main(String[] args) {
        int[] test = new int[]{1,3,4,5};
        int m = 2;
        int n = 2;
        printUtils.printArray(construct2DArray(test,m,n));

    }

    /**
     * ��Ŀ�ܼ򵥣���ѭ��һ�߾͹��ˡ������е�˼������һֱǷȱ�ģ��Ҹо��Լ�һֱȱ���ԡ��㷨���������������⣬ˢ�˺ܶ���㷨����
     * �о����ǲ��ܹ�������˵��������һ��ǰ����д��shell��̣�����һ�Ѳ���Ȼ�����һ�Ѳ������㷨�����м�Ĵ�����̣���ͻȻ��Щ������
     * ����ʵ��һ�ֳ��������Ľ�ϡ���ʱ���ڱ�̵�ʱ�������ͷ�벻�������п��ܾ��Ƕ���̫�����ĳ���������������������������ȫ����
     * ����Ҫ�ҵ�һ��������������ʹ�õĴ�����̣�������������и��õ�ʱ�临�ӶȺͽ�׳��
     * @param original
     * @param m
     * @param n
     * @return
     */
    public static int[][] construct2DArray(int[] original, int m, int n) {
        if(m * n != original.length){
            return new int[0][0];
        }
        int[][] arr = new int[m][n];
        int index = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = original[index++];
            }
        }
        return arr;
    }
}
