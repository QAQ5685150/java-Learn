package com.cn.Algorithm.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-04-19 21:40
 * @Description: TODO
 * @Project_name: java-learn
 */
public class findCircleNum_offer116 {

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,0,0},{0,1,0},{0,0,1}};
        findCircleNum_dfs(test);
        findCircleNum_bfs(test);
    }

    /**
     * dfs
     * @param isConnected
     */
    public static void findCircleNum_dfs(int[][] isConnected){
        int length = isConnected.length;
        boolean[] visited = new boolean[length];
        int ans = 0;
        for (int i = 0; i < length; i++) {
            if(!visited[i]){
                dfs(isConnected,visited,i);
                ans++;
            }
        }
        System.out.println(ans);
    }
    public static void dfs(int[][] isConnected, boolean[] visited, int index){
        for (int i = 0; i < isConnected[0].length; i++) {
            if(isConnected[index][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(isConnected,visited,i);
            }
        }
    }


    public static void findCircleNum_bfs(int[][] isConnected){
        int length = isConnected.length;
        Queue<Integer> queue = new LinkedList<>();

        int ans = 0;
        boolean[] visited = new boolean[length];

        for (int i = 0; i < length; i++) {
            //visited数组是为了判断当前数组有没有被访问到，没有访问过就标记为访问，然后ans++表示找到一个省份
            //然后bfs或dfs去在每个数组内去搜索所有“连在一起”的节点，在visited[]里标记上，下次再访问到标记过，就跳过
            if(!visited[i]){
                //bfs逻辑
                queue.offer(i);
                while (!queue.isEmpty()){
                    Integer cur = queue.poll();
                    visited[cur] = true;
                    for (int j = 0; j < isConnected[0].length; j++) {
                        if(isConnected[cur][j] == 1 && !visited[cur]){
                            queue.offer(j);
                        }
                    }
                }
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void findCircleNum_union(int[][] isConnected){
        int length = isConnected.length;
        int[] parent = new int[length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if(isConnected[i][j] == 1){
                    union(parent,i,j);
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < parent.length; i++) {
            if(parent[i] == i){
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static void union(int[] parent, int i,int j){
        parent[find(parent,i)] = find(parent,j);
    }

    public static int find(int[] parent, int i){
        if(parent[i] != i){
            parent[i] = find(parent,parent[i]);
        }
        return parent[i];
    }
}
