package com.ly.ch4;


import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;

public class Graph {
    private final int V;//顶点数目
    private int E;//边的数目
    private Bag<Integer>[] adj;//邻接表

    public Graph(int V) {
        this.V = V;//初始化顶点
        this.E = 0;//初始化没有边
        adj = (Bag<Integer>[]) new Bag[V];//创建邻接表
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt()); //初始化顶点数及邻接表(放相邻顶点用)
        int E = in.readInt();//读取边数
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    //返回顶点数
    public int V() {
        return V;
    }

    //返回边数
    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) {
            degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            //查找每个顶点的度并进行比较
            if (degree(G, v) > max) {
                max = degree(G, v);
            }
        }
        return max;
    }

    //所有顶点的平均度数
    public static double avgDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) count++;
            }
        }
        return count / 2;
    }

    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ":";
            for (int w : this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
}
