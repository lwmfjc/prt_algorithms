package com.ly.ch4;

public interface IGraph {
    int V();//顶点数
    int E();//边数
    void addEdge(int v,int w);//添加边
    Iterable<Integer> adj(int v);//顶点v的所有相邻顶点
    //static int degree(Graph G,int v); //顶点v有几个度
    //static int maxDegree(Graph G);//图的最大度
    //static double avgDegree(Graph G);//图的平均度
    //static int numberOfSelfLoops(Graph G);//图的自环数量
    //String toString();//展示多少个顶点多少条边
    //展示每个顶点和其他的哪些顶点有所连接


}
