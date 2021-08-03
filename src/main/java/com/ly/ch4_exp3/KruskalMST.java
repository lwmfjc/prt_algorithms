package com.ly.ch4_exp3;

import com.ly.ch1.Queue;
import com.ly.ch1.UF;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;

public class KruskalMST {
    private Queue<Edge> mst;//最小生成树的边

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge e : G.edges()) {
            pq.insert(e);
        }
        UF uf = new UF(G.V());
        //从pq中找出 v-1条边就是最小生成树
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (uf.connected(v, w)) continue;
            uf.union(v, w);
            mst.enqueue(e);
        }
    }
    public Iterable<Edge> edges(){
        return mst;
    }
    public double weight(){

        double weightT = 0.00;
        for (Edge e : mst) {
            weightT += e.weight();
        }
        return weightT;
    }
    public static void main(String[] args) {
        EdgeWeightedGraph G = new EdgeWeightedGraph(
                new In(args[0]));
        System.out.println("MST----------");
        KruskalMST mst = new KruskalMST(G);
        for (Edge edge : mst.edges()) {
            System.out.print(edge + "---");
        }
        System.out.println("------" + mst.weight() + "----");
        System.out.println(G);
    }

}
