package com.ly.ch4_exp3.ly1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;

import java.math.BigDecimal;

public class PrimMST {
    private boolean[] marked;
    private IndexMinPQ<Double> pq;
    private Edge[] edgeTo;//目前顶点w到树的阻断路径
    private double[] distTo;//目前顶点w到树的最短路径长度
    private BigDecimal weightT=new BigDecimal(0.00);

    public PrimMST(EdgeWeightGraph G) {
        marked = new boolean[G.V()];
        pq = new IndexMinPQ<>(G.V());
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;//无穷大
        }

        distTo[0]=0.00;
        pq.insert(0, 0.00);
        while (!pq.isEmpty()) {
            visit(G, pq.delMin());
        }
    }

    private void visit(EdgeWeightGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if(marked[w]) continue;
            if (e.weight() < distTo[w]) {
                distTo[w] = e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) {
                    pq.changeKey(w, e.weight());
                } else {
                    pq.insert(w, e.weight());
                }
            }
        }
    }

    public Iterable<Edge> edges() {
        Queue<Edge> edges = new Queue<>();
        for (int e = 1; e < edgeTo.length; e++) {
            edges.enqueue(edgeTo[e]);
        }
        return edges;
    }


    public double weight() {
        for (int i = 0; i < distTo.length; i++) {
            weightT = weightT.add(new BigDecimal(distTo[i]));
        }
        return weightT.doubleValue();
    }

    public static void main(String[] args) {
        EdgeWeightGraph G = new EdgeWeightGraph(new In("ly1/in.txt"));
        //System.out.println(G);
        PrimMST mst = new PrimMST(G);
        for (Edge e : mst.edges()) {
            System.out.println(e.either() + "-" + e.other(e.either()) + "[" + String.format("%.2f", e.weight()) + "]");
        }
        System.out.println(mst.weight());
    }
}
