package com.ly.ch4_exp3.ly1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

import java.math.BigDecimal;

//最小生成树
public class LazyPrimMST {
    private boolean[] marked;//标记顶点是否已经遍历
    private MinPQ<Edge> pq;//横切边
    private Queue<Edge> mst;//最下生成树的边
    private BigDecimal weightT = new BigDecimal(0.00);

    public LazyPrimMST(EdgeWeightGraph G) {
        marked = new boolean[G.V()];
        pq = new MinPQ<>();
        mst = new Queue<>();
        visit(G, 0);
        //从横切边选出属于最小生成树的边
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.enqueue(e);
            weightT = weightT.add(new BigDecimal(e.weight()));
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }
    }

    private void visit(EdgeWeightGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    public Iterable<Edge> mst() {
        return mst;
    }

    public double weight() {
        return weightT.doubleValue();
    }

    public static void main(String[] args) {
        EdgeWeightGraph G = new EdgeWeightGraph(new In("ly1/in.txt"));
        //System.out.println(G);
        LazyPrimMST mst = new LazyPrimMST(G);
        for (Edge e : mst.mst()) {
            System.out.println(e.either() + "-" + e.other(e.either()) + "[" + String.format("%.2f", e.weight()) + "]");
        }
        System.out.println("最短长度为:" + mst.weight());
    }
}
