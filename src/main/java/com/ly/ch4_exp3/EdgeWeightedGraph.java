package com.ly.ch4_exp3;

import com.ly.ch1.Bag;
import com.ly.ch1.Queue;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class EdgeWeightedGraph {
    private int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public EdgeWeightedGraph(In in) {
        this(in.readInt());//用定点数构造对象
        int e = in.readInt();
        for (int x = 0; x < e; x++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new Edge(v, w, weight));
        }
    }

    public int V(){
        return V;
    }
    public int E(){
        return E;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> b = new Bag<>();
        //每条边的权重不一样
        for (int v = 0; v < V; v++) {
            for (Edge e : adj[v]) {
                if (e.other(v) > v) {
                    b.add(e);
                }
            }
        }
        return b;
    }

    @Override
    public String toString() {
        String s = "EdgeWeightedGraph{" +
                "V=" + V +
                ", E=" + E +
                "}\n";
        for (int v = 0; v < V; v++) {
            s += v + ":";
            for (Edge edge : adj(v)) {
                int v1 = edge.either();
                int v2 = edge.other(v1);
                double weight = edge.weight();
                s += (v1 + "-" + v2 + "[" + weight + "]");
                s += "  ";
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        EdgeWeightedGraph graph = new EdgeWeightedGraph(
                new In(args[0])
        );
        System.out.println(graph);
    }
}
