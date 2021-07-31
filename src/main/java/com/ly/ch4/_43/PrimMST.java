package com.ly.ch4._43;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;

/**
 * 非延时算法
 */
public class PrimMST {
    private Edge[] edgeTo;//到某个顶点最近的边
    private double[] distTo; //到某个顶点最近的距离
    private boolean[] marked;
    private IndexMinPQ<Double> pq;//有效的横切边

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;//无穷大
        }
        pq = new IndexMinPQ<>(G.V());//索引优先队列
        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty()) {
            visit(G, pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue;
            if (e.weight() < distTo[w]) {
                //连接w和树的最佳边Edge变为e
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w)) pq.change(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }
    public Iterable<Edge> edges(){
        Queue<Edge> queue=new Queue<>();
        for(int v=1;v<edgeTo.length;v++ ){
            queue.enqueue(edgeTo[v]);
        }
        return queue;
    }
    public static void main(String[] args) {
        EdgeWeightedGraph graph=new EdgeWeightedGraph(new In(args[0]));
        PrimMST lazyPrimMST=new PrimMST(graph);
        for(Edge edge:lazyPrimMST.edges()){
            System.out.println("["+edge.either()+"]--"+"["+edge.other(edge.either())+"]");
        }
    }
}
