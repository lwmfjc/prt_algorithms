package com.ly.ch4_exp3.ly1;

import com.ly.ch1.Bag;
import com.ly.ch1.Queue;
import edu.princeton.cs.algs4.In;

//无向权重图
public class EdgeWeightGraph {
    private Bag<Edge>[] adj;
    private int V;//顶点个数
    private int E;//边的条数

    public EdgeWeightGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public EdgeWeightGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int e = 0; e < E; e++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new Edge(v, w, weight));
        }
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    private void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        this.E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<Edge> edges() {
        Queue<Edge> edges = new Queue<>();
        for (int v = 0; v < V(); v++) {
            for (Edge e : adj(v)) {
                int w = e.other(v);
                if (w > v) {
                    edges.enqueue(e);
                }
            }
        }
        return edges;
    }

    @Override
    public String toString() {
        String s = "EdgeWeightGraph{" +
                "  V=" + V +
                ", E=" + E +
                "}\n";
        for (int v = 0; v < V; v++) {
            s += v + ":";
            for (Edge e : adj(v)) {
                int v1 = e.either();
                int v2 = e.other(v1);
                s += v1 + "-" + v2 + "[" + String.format("%.2f", e.weight()) + "] ";
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        EdgeWeightGraph G = new EdgeWeightGraph(new In("in.txt"));
        System.out.println(G);
    }
}
