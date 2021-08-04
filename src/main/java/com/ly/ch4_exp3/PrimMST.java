package com.ly.ch4_exp3;

import com.ly.ch1.Queue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;

import java.math.BigDecimal;

//最小生成树的Prim算法的延迟实现
//核心：一个顶点到最小生成树的最短距离只会有一条
public class PrimMST {
    private boolean[] marked;
    private double[] distTo;//最佳距离
    private Edge[] edgeTo;//最佳边
    private IndexMinPQ<Double> pq;//有效的横切边(的长度)

    public PrimMST(EdgeWeightedGraph G) {
        marked = new boolean[G.V()];
        distTo = new double[G.V()];//最小生成树的距离
        edgeTo = new Edge[G.V()];//最小生成树的边
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;//最大的double
        }
        pq = new IndexMinPQ<>(G.V());
        pq.insert(0, 0.00);//有效边
        while (!pq.isEmpty()) {
            int min = pq.delMin();
            visit(G, min);
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue;
            //加入的时候就判断顶点w到树的横切边(只
            // 在pq存储w到最小生成树横切边最小的距离)
            if (e.weight() < distTo[w]) {
                //点w到最小生成树的最短路径(暂时)为e
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w)) {
                    pq.changeKey(w, e.weight());
                } else {
                    pq.insert(w, e.weight());
                }
            }

        }

    }

    private Iterable<Edge> edge() {
        Queue<Edge> queue = new Queue<>();
        for (int i = 1; i < edgeTo.length; i++) {
            queue.enqueue(edgeTo[i]);
        }
        return queue;
    }

    public double weight() {
        //用double会导致精度问题
        BigDecimal weightT = new BigDecimal(0.00);
        for (Edge e : edge()) {
            weightT = weightT.add(new BigDecimal(e.weight()));
        }
        return weightT.doubleValue();
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
