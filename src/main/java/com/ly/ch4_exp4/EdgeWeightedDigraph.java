package com.ly.ch4_exp4;

import com.ly.ch1.Bag;
import com.ly.ch4_exp3.Edge;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

//有权方向图
public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public EdgeWeightedDigraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int e = 0; e < E; e++) {
            int from = in.readInt();
            int to = in.readInt();
            double weight = in.readDouble();
            addEdge(new DirectedEdge(from, to, weight));
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    private void addEdge(DirectedEdge edge) {
        adj[edge.from()].add(edge);
        this.E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        String s = "EdgeWeightedDigraph{" +
                "V=" + V +
                ", E=" + E + "}\n";
        for (int v = 0; v < V(); v++) {
            s += v + ":";
            for (DirectedEdge edge : adj(v)) {
                s += edge.from() + "->" + edge.to() + "[" + String.format("%.2f", edge.weight()) + "]  ";
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In("din.txt"));
        System.out.println(G);
    }
}
