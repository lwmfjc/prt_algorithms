package com.ly.ch4_exp4;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.LinkedList;
import java.util.Queue;

public class Dijkstra {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;

    public Dijkstra(EdgeWeightedDigraph G) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        pq = new IndexMinPQ<>(G.V());
        for (int v = 0; v < distTo.length; v++) {
            distTo[v] = Double.POSITIVE_INFINITY;//初始化为无穷大
        }
        distTo[0] = 0.00;
        pq.insert(0, 0.00);
        while (!pq.isEmpty()) {
            relax(G, pq.delMin());
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    public Iterable<DirectedEdge> edges() {
        Queue<DirectedEdge> edges = new LinkedList<>();
        for (int v = 1; v < edgeTo.length; v++) {
            edges.add(edgeTo[v]);
        }
        return edges;
    }

    public static void main(String[] args) {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In("din.txt"));
        //System.out.println(G);
        Dijkstra dijkstra = new Dijkstra(G);
        for (DirectedEdge e : dijkstra.edges()) {
            System.out.println(e);
        }
    }
}
