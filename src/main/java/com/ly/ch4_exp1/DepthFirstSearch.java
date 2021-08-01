package com.ly.ch4_exp1;

import edu.princeton.cs.algs4.In;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;//连通分量个数

    public DepthFirstSearch(Graph G) {
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                count++;
                dfs(G, v);
                System.out.println();
            }
        }
    }

    public void dfs(Graph G, int v) {
        marked[v] = true;//顶点v已经访问
        System.out.print(v+" ");
        for (int w : G.adj(v)) {//遍历v的所有相邻顶点
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        DepthFirstSearch search=new DepthFirstSearch(G);
        System.out.println(search.count());
    }
}
