package com.ly.ch4_exp1;

import com.ly.ch1.Bag;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class Graph {
    private int V;//顶点个数
    private int E;//边数
    private Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[this.V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int e = 0; e < E; e++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    /**
     * 添加边
     *
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        this.E++;
    }

    /**
     * 遍历v的相邻顶点
     *
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return E;
    }

    @Override
    public String toString() {
        String s = "Graph{vertex num[" + this.V + "]--" + "edge num[" + this.E + "]}\n";
        for (int v = 0; v < this.V(); v++) {
            s += v + ":";
            for (int w : adj(v)) {
                s += w+" ";
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        System.out.println(G);
    }
}
