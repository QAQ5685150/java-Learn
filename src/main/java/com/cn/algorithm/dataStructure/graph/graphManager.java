package com.cn.algorithm.dataStructure.graph;

import java.util.Arrays;
import java.util.List;

/**
 * 类名: graphManager
 * 描述: 图结构管理类 组合IGraph接口管理图
 * 姓名: @author南风
 * 日期: 2021-12-17 11:19
 **/
public class graphManager {

    /**
     *功能描述:获取图的邻接表测试数据
     *@return com.cn.algorithm.dataStructure.graph.graphList
     **/
    public static graphList getGlTestData(){
        graphList gl;
        synchronized (graphManager.class){
            List<VertexNode> vertexNodes = Arrays.asList(new VertexNode("A"), new VertexNode("B"), new VertexNode("C"),
                    new VertexNode("D"), new VertexNode("E"), new VertexNode("F"), new VertexNode("G"),
                    new VertexNode("H"), new VertexNode("I"));

            gl = new graphList(vertexNodes);

            gl.insertEdge(new EdgeNode(0,1,1),new EdgeNode(0,5,1),new EdgeNode(1,2,1),
                    new EdgeNode(1,6,1), new EdgeNode(1,8,1),new EdgeNode(4,5,1),
                    new EdgeNode(5,6,1),new EdgeNode(2,8,1),new EdgeNode(3,8,1),
                    new EdgeNode(2,3,1),new EdgeNode(6,7,1),new EdgeNode(3,7,1),
                    new EdgeNode(3,4,1),new EdgeNode(3,6,1),new EdgeNode(4,7,1));
        }
        return gl;
    }

    /**
    *功能描述:获取图的临界矩阵表示测试数据
    *@return com.cn.algorithm.dataStructure.graph.graphMatrix
    **/
    public static graphMatrix getGmTestData(){
        graphMatrix gm;
        synchronized (graphManager.class){
            List<String> list = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I");
            gm = new graphMatrix(list, list.size(), 15);
            int[][] edges = new int[][]{{0,1},{0,5},
                    {1,2},{1,6},{1,8},
                    {2,3},{2,8},{3,4},
                    {3,6},{3,7},{3,8},
                    {4,5},{4,7},{5,6},
                    {6,7}};
            List<Integer> arr = Arrays.asList(1, 3, 5, 3, 2, 6, 4, 5, 2, 7, 8, 9, 6, 5, 3);
            gm.insert(edges,arr);

        }
        return gm;
    }

    public static void main(String[] args) {
        graphList glTestData = getGlTestData();
        glTestData.printGraph();

        graphMatrix gmTestData = getGmTestData();
        gmTestData.printGraph();
    }
}


