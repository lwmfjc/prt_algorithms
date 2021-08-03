package com.ly.ch4_exp3;

import com.ly.ch1.Queue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.MinPQ;

//最小生成树的Prim算法的延迟实现
public class PrimMST {
    private boolean[] marked;
    private double[] distTo;
    private Queue<Edge> mst;//最小生成树的边
    private IndexMinPQ<Edge> pq;//横切边

    public PrimMST(EdgeWeightedGraph G) {
        marked = new boolean[G.V()];
        pq = new IndexMinPQ<>(G.V());
        mst = new Queue<>();
        visit(G, 0);
        while (!pq.isEmpty()) {
            int w = pq.delMin();//顶点w
            visit(G, w);
        }
    }


    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue;
            //找到依附该点的边,这条边的另一个顶点不能是标记过的
            if (e.weight() < distTo[w]) {
                distTo[w] = e.weight();
                if (pq.contains(w)) {
                    pq.changeKey(w, e);
                } else {
                    pq.insert(w, e);
                }
            }
        }
    }

    public Iterable<Edge> edge() {
        return mst;
    }

    public double weight() {
        double weightT = 0.00;
        /*for (Edge e : mst) {
            weightT += e.weight();
        }*/
        for(double weight:distTo){
            weightT+=weight;
        }
        return weightT;
    }

    public static void main(String[] args) {
        EdgeWeightedGraph G = new EdgeWeightedGraph(
                new In(args[0]));
        System.out.println("MST----------");
        PrimMST primMST = new PrimMST(G);
        for (Edge edge : primMST.edge()) {
            System.out.print(edge + "---");
        }
        System.out.println("------" + primMST.weight() + "----");
        System.out.println(G);
    }
}
