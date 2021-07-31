package com.ly.ch4._43;

import com.ly.ch1.Queue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;

public class LazyPrimMST {
    private boolean[] marked;//最小生成树的顶点

    private Queue<Edge> mst;//最小生成树的边

    private MinPQ<Edge> pq;//横切边(包括失效的边)

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new MinPQ<>();
        marked = new boolean[G.V()];
        mst = new Queue<>();
        visit(G, 0);//前提G是连通的
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.enqueue(e);//将边添加到树中
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                //未被标记的顶点才会加入pq(在最小生成树之外的顶点)
                pq.insert(e);
            }
        }
    }
    public Iterable<Edge> mst(){
        return mst;
    }

    public static void main(String[] args) {
        EdgeWeightedGraph graph=new EdgeWeightedGraph(new In(args[0]));
        LazyPrimMST lazyPrimMST=new LazyPrimMST(graph);
        for(Edge edge:lazyPrimMST.mst()){
            System.out.println("["+edge.either()+"]--"+"["+edge.other(edge.either())+"]");
        }
    }
}
