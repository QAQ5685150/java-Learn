package com.cn.algorithm.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 类名: catMouseGame_913
 * 描述: TODO
 * 姓名: @author南风
 * 日期: 2022-01-04 16:18
 **/
public class catMouseGame_913 {

    private static int[][] edges;

    private static List<Integer> vertex = new ArrayList<>();

    private static boolean[] isCatVisited;

    private static boolean[] isMouseVisited;

    /**
     * 功能描述:两位玩家分别扮演猫和老鼠，在一张 无向 图上进行游戏，两人轮流行动。
     * 图的形式是：graph[a] 是一个列表，由满足 ab 是图中的一条边的所有节点 b 组成。
     * 老鼠从节点 1 开始，第一个出发；猫从节点 2 开始，第二个出发。在节点 0 处有一个洞。
     * 在每个玩家的行动中，他们 必须 沿着图中与所在当前位置连通的一条边移动。例如，如果老鼠在节点 1 ，那么它必须移动到 graph[1] 中的任一节点。
     * 此外，猫无法移动到洞中（节点 0）。
     * 然后，游戏在出现以下三种情形之一时结束：
     *
     * 如果猫和老鼠出现在同一个节点，猫获胜。
     * 如果老鼠到达洞中，老鼠获胜。
     * 如果某一位置重复出现（即，玩家的位置和移动顺序都与上一次行动相同），游戏平局。
     * 给你一张图 graph ，并假设两位玩家都都以最佳状态参与游戏：
     *
     * 如果老鼠获胜，则返回1；
     * 如果猫获胜，则返回 2；
     * 如果平局，则返回 0 。
    **/
    public static void main(String[] args) {
        int[][] graph = new int[][]{{2,5},{3},{0,4,5},{1,4,5},{2,3},{0,2,3}};
        System.out.println(catMouseGame_test(graph));
    }

    /**
    *功能描述:test
    *@param graph
    *@return int
    **/
    public static int catMouseGame_test(int[][] graph) {
        //邻接矩阵建图
        edges = new int[graph.length][graph.length];
        isCatVisited = new boolean[graph.length];
        isMouseVisited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            vertex.add(i);
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                edges[i][graph[i][j]] = 1;
            }
        }
        Queue<Integer> mouse = new LinkedList<>();
        Queue<Integer> cat = new LinkedList<>();

        mouse.offer(1);
        isMouseVisited[1] = true;
        cat.offer(2);
        isCatVisited[2] = true;

        while (!mouse.isEmpty() ||!cat.isEmpty()){
            Integer m = mouse.poll();
            Integer c = cat.poll();
            for (int i = 0; i < vertex.size(); i++) {
                if(edges[m][i] != 0 && !isMouseVisited[i]){
                    if(i == c) continue;
                    if(i == 0) return 1;
                    mouse.offer(i);
                    isMouseVisited[i] = true;
                    continue;
                }
            }
            for (int j = 1; j < vertex.size(); j++) {
                if(edges[c][j] != 0 && !isCatVisited[j]){
                    if(j == mouse.peek()) return 2;
                    cat.offer(j);
                    isCatVisited[j] = true;
                    continue;
                }
            }
        }
        return 0;
    }


    public static int catMouseGame_bfs(int[][] graph) {



        return 0;
    }
}