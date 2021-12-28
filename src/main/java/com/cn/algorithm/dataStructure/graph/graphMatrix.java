package com.cn.algorithm.dataStructure.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 类名: graphMatrix
 * 描述: 图的邻接矩阵 dfs & bfs
 * 姓名: @author南风
 * 日期: 2021-12-16 10:21
 **/
public class graphMatrix implements IGraph{

    //顶点表
    private List<String> vertex;

    //边表 二维数组保存两个顶点之间是否有边，也可用权值表示
    private int[][] edges;

    //顶点数目
    private int numVertexes;

    //边数目
    private int numEdges;

    //是否访问标志状态位
    private boolean[] visited;

    public graphMatrix(List<String> list,int numVertexes, int numEdges) {
        this.numVertexes = numVertexes;
        this.numEdges = numEdges;
        this.vertex = list;
        this.visited = new boolean[numVertexes];
        this.edges = new int[numVertexes][numVertexes];
    }

    public void insert(int[][] arrays,List<Integer> value){
        int index = 0;
        for (int[] anInt : arrays) {
            if(index < value.size()){
                Integer integer = value.get(index++);
                edges[anInt[0]][anInt[1]] = integer;
            }
        }
    }

    /**
    *功能描述:展示当前图结构
    *@return void
    **/
    public void printGraph(){
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    /**
    *功能描述:图的深度优先遍历
    *@return void
    **/
    public void DFS(){
        for (int i = 0; i < visited.length; i++) {
            this.visited[i] = false;
        }
        System.out.print("深度优先遍历：");
        for (int i = 0; i < numVertexes; i++) {
            if(!visited[i]){
                dfsProcess(i);
            }
        }
    }

    /**
    *功能描述:DFS process
    *@paramnum Vertexes 当前邻接矩阵的“行数” 代表当前节点，遍历是对此节点边表的“整行”，代表一个for循环
    *@return void
    **/
    public void dfsProcess(int numVertexes){
        //标记访问标志位置
        visited[numVertexes] = true;
        //遍历操作，可以理解为树的遍历“可替换模板”，遍历到当前节点执行的操作
        System.out.print(vertex.get(numVertexes) + " ");

        for (int i = 0; i < this.numVertexes; i++) {
            if(edges[numVertexes][i] > 0 && !visited[i]){
                dfsProcess(i);
            }
        }
    }

    /**
    *功能描述:图的广度优先遍历
    *@return void
    **/
    public void BFS(){
        //还原遍历标志位
        System.out.print("广度优先遍历：");
        for (int i = 0; i < visited.length; i++) {
            this.visited[i] = false;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numVertexes; i++) {
            if(!visited[i]){
                visited[i] = true;
                System.out.print(vertex.get(i) + " ");
                queue.add(i);
                while (!queue.isEmpty()){
                    Integer poll = queue.poll();
                    for (int j = 0; j <this.numVertexes; j++) {
                        if(edges[poll][j] > 0 && !visited[j]){
                            visited[j] = true;
                            System.out.print(vertex.get(j) + " ");
                            queue.add(j);
                        }
                    }
                }
            }
        }
    }
}

class test{

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I");
        graphMatrix gm = new graphMatrix(list, list.size(), 15);
        int[][] edges = new int[][]{{0,1},{0,5},
                {1,2},{1,6},{1,8},
                {2,3},{2,8},{3,4},
                {3,6},{3,7},{3,8},
                {4,5},{4,7},{5,6},
                {6,7}};
        List<Integer> arr = Arrays.asList(1, 3, 5, 3, 2, 6, 4, 5, 2, 7, 8, 9, 6, 5, 3);
        gm.insert(edges,arr);
        gm.printGraph();
        gm.DFS();
        System.out.println();
        gm.BFS();
    }
}
