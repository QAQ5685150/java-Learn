package com.cn.algorithm.graph;

/**
 * 类名: IGraph
 * 描述: 图结构接口
 * 姓名: @author南风
 * 日期: 2021-12-17 11:14
 **/
public interface IGraph {

    /**
    *功能描述:展示图结构
    *@return void
    **/
    void printGraph();

    /**
     *功能描述:深度优先遍历
     *@return void
     **/
    void DFS();

    /**
     *功能描述:广度优先遍历
     *@return void
     **/
    void BFS();




}
