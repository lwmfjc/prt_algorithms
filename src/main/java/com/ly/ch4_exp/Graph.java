package com.ly.ch4_exp;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {
    private int V;//顶点数
    private int E;//边数
    private Bag<Integer>[] adj;//邻接表

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        //初始化邻接表
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    //使用输入流初始化图
    public Graph(In in) {
        this(in.readInt());//顶点数
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }


    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    //添加边
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        String s = "vertex num [" + V + "]" + "edge num [" + E + "]\n";
        for (int v = 0; v < V; v++) {
            s += (v + ":");
            for (int w : adj(v)) {
                s += (w + " ");
            }
            s += "\n";
        }
        return s;
    }

    //顶点v的度数
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int i : G.adj(v)) {
            degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph G) {
        int maxDegree = 0;
        for (int v = 0; v < G.V(); v++) {
            if (G.degree(G, v) > maxDegree) {
                maxDegree = G.degree(G, v);
            }
        }
        return maxDegree;
    }

    public static int avgDegree(Graph G) {
        return G.E() * 2 / G.V();
    }

    //自环的数量
    public int numberOfSelfLoops(Graph G) {
        int nums = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) {
                    nums++;
                }
            }
        }
        return nums / 2;
    }

    public static void main(String[] args) {
        //第一个参数是文件名
        Graph G = new Graph(new In(args[0]));
        System.out.println(G);
    }
}
