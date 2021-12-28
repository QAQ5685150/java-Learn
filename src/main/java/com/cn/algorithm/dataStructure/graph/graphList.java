package com.cn.algorithm.dataStructure.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 类名: graphList
 * 描述: 邻接表
 * 姓名: @author南风
 * 日期: 2021-12-16 15:17
 **/
public class graphList implements IGraph{

    private List<VertexNode> vertexNodes;

    private int vertexNum;

    private int edgeNum;

    private boolean[] visited;

    public graphList(List<VertexNode> vertexNodes) {
        //插入节点 构造时直接插入所有的顶点节点
        this.vertexNodes = vertexNodes;
        this.vertexNum = vertexNodes.size();
        this.edgeNum = 0;
        this.visited = new boolean[vertexNodes.size()];
    }

    /**
    *功能描述:插入边节点
    *@param e {@EdgeNode}边节点
    *@return void
    **/
    public void insertEdge(EdgeNode ... e){
        for (EdgeNode edgeNode : e) {
            int i = edgeNode.vex; // 顶点表中对应结点的下标
            int j = edgeNode.adjvex; // 边表结点对应的下标
            VertexNode vexi = vertexNodes.get(i);
            VertexNode vexj = vertexNodes.get(j);
            //尾插法插入
            edgeNode.next = vexi.firstEdge;
            vexi.firstEdge = edgeNode;

            //边节点插两次 双向 例如：插入一条边节点（6，8）就会有一条（8，6）
            EdgeNode e2 = new EdgeNode(j, i, 1);
            e2.next = vexj.firstEdge;
            vexj.firstEdge = e2;

            edgeNum++;
        }
    }

    /**
    *功能描述:获取边总数
    *@return Integer
    **/
    public Integer getEdgeNum(){
        return this.edgeNum;
    }

    /**
    *功能描述:打印邻接表
    *@return void
    **/
    public void printGraph(){
        if(vertexNodes.size() == 0){
            System.out.println("请先构造邻接表");
            return;
        }
        System.out.println("当前邻接表为： ");
        for (int i = 0; i < vertexNum; i++) {
            VertexNode vex = vertexNodes.get(i);
            System.out.print("【" + vex.data + "】—> ");
            EdgeNode node = vex.firstEdge;
            while (node != null) {
                System.out.print(vertexNodes.get(node.adjvex).data + "(" + node.adjvex + ")" + "-> ");
                node = node.next;
            }
            System.out.print("null");
            System.out.println();
        }
    }

    /**
    *功能描述:DFS 深度优先遍历
    *@return void
    **/
    public void DFS(){
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        System.out.println("深度优先遍历：");
        for (int i = 0; i < vertexNodes.size(); i++) {
            if(!visited[i]){
                process(i);
            }
        }
    }
    
    public void process(int i){
        EdgeNode e;
        visited[i] = true;
        System.out.print(vertexNodes.get(i).data + " ");
        e = vertexNodes.get(i).firstEdge;
        while (e != null){
            if(!visited[e.adjvex]){
                process(e.adjvex);
            }
            e = e.next;
        }
    }

    /**
    *功能描述:BFS 广度优先遍历
    *@return void
    **/
    public void BFS(){
//        EdgeNode p;
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < visited.length; i++) {
//            visited[i] = false;
//        }
//        System.out.println("广度优先遍历： ");
//        for (int i = 0; i < vertexNodes.size(); i++) {
//
//            if(!visited[i]){
//                visited[i] = true;
//                System.out.print(vertexNodes.get(i).data + " ");
//                queue.add(i);
//                while (!queue.isEmpty()){
//                    i = queue.poll();
//                    p = vertexNodes.get(i).firstEdge;
//                    if(!visited[p.adjvex]){
//                        visited[p.adjvex] = true;
//                        System.out.print(vertexNodes.get(p.adjvex).data + " ");
//                        queue.add(p.adjvex);
//                    }
//                    p = p.next;
//                }
//            }
//        }

        EdgeNode p;
        int i;
        LinkedList queue = new LinkedList();
        for (i = 0; i < vertexNum; i++) {
            visited[i] = false;
        }
        System.out.println("广度优先遍历： ");
        for (i = 0; i < vertexNum; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.print(vertexNodes.get(i).data + " ");
                queue.addLast(i);
                while (!queue.isEmpty()) {
                    i = (Integer) queue.removeFirst();
                    p = vertexNodes.get(i).firstEdge;
                    while (p != null) {
                        if (!visited[p.adjvex]) {
                            visited[p.adjvex] = true;
                            System.out.print(vertexNodes.get(p.adjvex).data + " ");
                            queue.addLast(p.adjvex);
                        }
                        p = p.next;
                    }
                }
            }
        }
    }
}

/**
*功能描述: 邻接表顶点节点
**/
class VertexNode{

    String data;

    EdgeNode firstEdge;

    public VertexNode(String data) {
        this.data = data;
        this.firstEdge = null;
    }
}

/**
 *功能描述: 邻接表边节点
 **/
class EdgeNode{

    public int vex; //当前节点
    public int adjvex; //下一个节点（对应List<VertexNode> vertexNodes）
    public int weight;
    public EdgeNode next;

    public EdgeNode(int vex, int adjvex, int weight) {
        this.vex = vex;
        this.weight = weight;
        this.adjvex = adjvex;
        this.next = null;
    }
}
class test1{

    public static void main(String[] args) {
        List<VertexNode> vertexNodes = Arrays.asList(new VertexNode("A"), new VertexNode("B"), new VertexNode("C"),
                new VertexNode("D"), new VertexNode("E"), new VertexNode("F"), new VertexNode("G"),
                new VertexNode("H"), new VertexNode("I"));

        graphList gl = new graphList(vertexNodes);

        gl.insertEdge(new EdgeNode(0,1,1),new EdgeNode(0,5,1),new EdgeNode(1,2,1),
                new EdgeNode(1,6,1), new EdgeNode(1,8,1),new EdgeNode(4,5,1),
                new EdgeNode(5,6,1),new EdgeNode(2,8,1),new EdgeNode(3,8,1),
                new EdgeNode(2,3,1),new EdgeNode(6,7,1),new EdgeNode(3,7,1),
                new EdgeNode(3,4,1),new EdgeNode(3,6,1),new EdgeNode(4,7,1));

        gl.printGraph();

        System.out.println("邻接表边节点个数: " + gl.getEdgeNum());

        gl.DFS();

        System.out.println();

        gl.BFS();
//        测试插入节点
//        gl.insertEdge(new EdgeNode(8,6,1));
//
//        gl.printGraph();
    }

}
