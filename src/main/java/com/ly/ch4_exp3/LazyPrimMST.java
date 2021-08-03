package com.ly.ch4_exp3;

import com.ly.ch1.Queue;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;

import java.math.BigDecimal;

//最小生成树的Prim算法的延迟实现
public class LazyPrimMST {
    private boolean[] marked;
    private Queue<Edge> mst;//最小生成树的边
    private MinPQ<Edge> pq;//横切边

    public LazyPrimMST(EdgeWeightedGraph G) {
        marked = new boolean[G.V()];
        pq = new MinPQ<>();
        mst = new Queue<>();
        visit(G, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            //连接的两个顶点不能都在最小生成树中
            if (marked[v] && marked[w]) continue;
            mst.enqueue(e);
            if (!marked[v]) {
                visit(G, v);
            }
            if (!marked[w]) {
                visit(G, w);
            }
        }
    }


    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            //找到依附该点的边,这条边的另一个顶点不能是标记过的
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    public Iterable<Edge> edge() {
        return mst;
    }

    public double weight() {
        BigDecimal weightT = new BigDecimal(0.00);
        for (Edge e : mst) {
            weightT=weightT.add(new BigDecimal(e.weight()));
        }
        return weightT.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(0.19+0.26+0.17+0.28+0.35+0.40+0.16);
        System.out.println(0.16+0.19+0.26+0.17+0.28+0.35+0.40);
        EdgeWeightedGraph G = new EdgeWeightedGraph(
                new In(args[0]));
        System.out.println("MST----------");
        LazyPrimMST primMST = new LazyPrimMST(G);
        for (Edge edge : primMST.edge()) {
            System.out.print(edge + "---");
        }
        System.out.println("------" + primMST.weight() + "----");
        System.out.println(G);
    }
}
