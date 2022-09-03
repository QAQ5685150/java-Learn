package com.cn.Algorithm.search.dfs;


import java.util.*;

/**
 * @Author: Linxx
 * @Package: com.cn.algorithm.search.dfs
 * @Time: 2022-08-25 14:01
 * @Description: TODO
 **/
public class canFinish2_210 {

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        int[][] test1 = new int[][]{{1,2},{0,1}};
        for (int i : findOrder(3, test1)) {
            System.out.println(i + " ");
        }
    }

    static Stack<Integer> stack = new Stack<>();
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <= 1) return new int[]{0};
        int[] res = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i = 0; i < prerequisites.length; i++){
            if(!dfs(list,visited,i)) return new int[0];
        }
        for(int i = 0; i < numCourses && !stack.isEmpty(); i++){
            res[i] = stack.pop();
        }
        return res;
    }

    public static boolean dfs(List<List<Integer>> list, int[] visited,int cur){
        if(visited[cur] == 1) return false;
        if(visited[cur] == -1) return true;
        visited[cur] = 1;
        for(int i = 0; i < list.get(cur).size(); i++){
            if(!dfs(list,visited,list.get(cur).get(i))) {
                return false;
            }
        }
        visited[cur] = -1;
        stack.add(cur);
        return true;
    }
}
