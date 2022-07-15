package com.cn.algorithm.search.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.search.dfs
 * @Time: 2022-07-13 14:14
 * @Description: TODO
 **/
public class canFinish_207 {

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,4},{2,4},{3,1},{3,2}};
        System.out.println(canFinish2(5, test));
    }

    //dfs����ģ�壬�����ж��Ƿ��л�����
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        boolean[] visited = new boolean[numCourses];
        for(int i = 0;i < len; i++){
            if(!visited[i]){
                dfs(prerequisites,visited,i);
            }else {
                return false;
            }
        }
        return true;
    }

    public static boolean dfs(int[][] prerequisites, boolean[] visited, int index){
        int[] cur = prerequisites[index];
        for(int i = 0; i < cur.length; i++){
            if(!visited[cur[i]]){
                visited[cur[i]] = true;
            }else{
                return false;
            }
        }
        return true;
    }

    /**
     * ������������[1,4][4,1]����false�������޷��ж�ͼ�д��ڻ������
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        boolean[][] visited = new boolean[numCourses][numCourses];
        for(int i = 0;i < len; i++){
            int l = prerequisites[i][0];
            int r = prerequisites[i][1];
            visited[l][r] = true;
        }
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                if(i != j && visited[i][j] == true && visited[j][i] == true){
                    return false;
                }
            }
        }
        return true;
    }

    //�ж�ͼ�Ƿ�ΪDAG�����޻�ͼ
    public static boolean canFinish3(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        int[] visited = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < len; i++) {
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i = 0;i < len; i++){
            if(!dfs_dag(edges,visited,i)) return false;
        }
        return true;
    }

    private static boolean dfs_dag(List<List<Integer>> edges, int[] visited, int i) {
        if(visited[i] == 1) return false;
        if(visited[i] == -1) return true;
        visited[i] = 1;
        for (int j = 0; j < edges.get(i).size(); j++) {
            if(!dfs_dag(edges,visited,edges.get(i).get(j))) return false;
        }
        visited[i] = -1;
        return true;
    }
}
