package com.ly.ch4_exp4;


import com.ly.ch1.Bag;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

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
        int e = in.readInt();
        for (int n = 0; n < e; n++) {
            int from = in.readInt();
            int to = in.readInt();
            double weight = in.readDouble();
            addEdge(new DirectedEdge(from, to, weight));
        }
    }

    private void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    public int V(){
        return V;
    }
    public int E(){
        return E;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        String s = "EdgeWeightedDigraph{" +
                "V=" + V +
                ", E=" + E + "}\n";
        for (int v = 0; v < V; v++) {
            s += v + ":";
            for (DirectedEdge e : adj(v)) {
                int from = e.from();
                int to = e.to();
                double weight = e.weight();
                s += " [" + from + "->" + to +"("+weight+ ")] ";
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        EdgeWeightedDigraph G =
                new EdgeWeightedDigraph(new In(args[0]));
        System.out.println(G);
    }
}
