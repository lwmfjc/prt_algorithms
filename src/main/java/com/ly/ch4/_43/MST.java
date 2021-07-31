package com.ly.ch4._43;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class MST {
    public MST(EdgeWeightedGraph G) {

    }

    Iterable<Edge> edges() {
        return null;
    }

    double weight() {
        return 0.0;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G;
        G = new EdgeWeightedGraph(in);

        MST mst = new MST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.println(mst.weight());
    }
}
