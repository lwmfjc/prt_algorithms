package com.ly.ch4_exp3.ly1;

import com.ly.ch1.Queue;
import com.ly.ch1.UF;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;

import java.math.BigDecimal;

public class KruskalMST {
    private Queue<Edge> mst;//最小生成树
    private BigDecimal weightT = new BigDecimal(0.00);

    public KruskalMST(EdgeWeightGraph G) {
        mst = new Queue<>();

        //将所有边加入横切边
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge e : G.edges()) {
            pq.insert(e);
        }
        UF uf = new UF(G.V());

        //每次取出一条边,这两条边不能连通
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge edge = pq.delMin();
            int v = edge.either();
            int w = edge.other(v);
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                mst.enqueue(edge);
                weightT = weightT.add(new BigDecimal(edge.weight()));
            }
        }
    }

    public double weight() {
        return weightT.doubleValue();
    }
    public Iterable<Edge> mst(){
        return mst;
    }

    public static void main(String[] args) {
        EdgeWeightGraph G = new EdgeWeightGraph(new In("ly1/in.txt"));
        // System.out.println(G);
        KruskalMST mst = new KruskalMST(G);
        for(Edge e:mst.mst()){
            System.out.println(e.either()+"-"+e.other(e.either())+"["+String.format("%.2f",e.weight())+"]");
        }
        System.out.println(mst.weight());
    }
}
