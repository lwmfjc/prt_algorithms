package com.ly.ch4_exp1;

import com.ly.ch1.Bag;
import edu.princeton.cs.algs4.In;

/**
 * 图的数据结构
 */
public class Graph {
    private int V;//点数
    private int E;//边数
    private Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        //添加E条边
        for (int x = 0; x < E; x++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }

    }

    public int E() {
        return E;
    }

    public int V() {
        return V;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        this.E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public String toString() {
        String s = "vertex num[" + this.V + "]" +
                "--edge num[" + this.E + "]\n";
        for (int v = 0; v < this.V; v++) {
            s += (v + ":");
            for (int w : adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }

    /**
     * 图的某顶点的度数
     *
     * @param G
     * @param v
     * @return
     */
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) {
            degree++;
        }
        return degree;
    }

    /**
     * 最大度数
     *
     * @param G
     * @return
     */
    public static int maxDegree(Graph G) {
        int maxDegree = 0;
        for (int v = 0; v < G.V(); v++) {
            if (degree(G, v) > maxDegree) {
                maxDegree = degree(G, v);
            }
        }
        return maxDegree;
    }

    /**
     * 自环的个数(无环图的自环)
     * @param G
     * @return
     */
    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        System.out.println(G);
    }


}
