package com.cn.algorithm.search.dfs;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.search.dfs
 * @Time: 2022-07-08 14:35
 **/
public class findCircleNum_547 {

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(test));
    }

    public static int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int count = 0;
        boolean[] isVisited = new boolean[len];
        for(int i = 0;i < len; i++){
            if(!isVisited[i]){
                count++;
                process(isConnected,isVisited,i);
            }
        }
        return count;
    }

    public static void process(int[][] isConnected,boolean[] isVisited,int i){
        for(int j = 0;j < isConnected.length; j++){
            if(isConnected[i][j] == 1 && !isVisited[j]){
                isVisited[j] = true;
                process(isConnected,isVisited,j);
            }
        }
    }
}
