package com.ly.ch4._44;

import com.ly.ch1.Bag;
import com.ly.ch4._43.Edge;
import edu.princeton.cs.algs4.In;

public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private Bag<DirectedEdge>[] adj;//邻接表

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        //每个顶点相邻的边
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<DirectedEdge>();
        }
    }

    public EdgeWeightedDigraph(In in) {
        this.V = in.readInt();
        int E = in.readInt();
        adj = (Bag<DirectedEdge>[]) new Bag[this.V];

        for (int x = 0; x < E; x++) {
            int from = in.readInt();
            int to = in.readInt();
            double weight = in.readDouble();
            addEdge(new DirectedEdge(from, to,
                    weight));
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj[v]) {
                bag.add(e);
            }
        }
        return bag;
    }


}
