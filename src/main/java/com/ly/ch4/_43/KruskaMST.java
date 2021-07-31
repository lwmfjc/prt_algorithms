package com.ly.ch4._43;

import com.ly.ch1.Queue;
import com.ly.ch1.UF;
import edu.princeton.cs.algs4.MinPQ;

public class KruskaMST {
    private Queue<Edge> mst;

    public KruskaMST(EdgeWeightedGraph G) {
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge e : G.edges()) {
            pq.insert(e);
        }
        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();//得到权重最小的边,及两个顶点
            int v = e.either(), w = e.other(v);
            //如果这两个顶点是连通的,那么不处理
            if (uf.connected(v, w)) continue;
            uf.union(v, w);
            mst.enqueue(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
}
