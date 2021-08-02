package com.ly.ch4_exp1;

import edu.princeton.cs.algs4.In;

/**
 * 与s连通的所有顶点
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int count = 0;//访问了几个顶点

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        DepthFirstSearch search = new DepthFirstSearch(G, s);
        for (int v = 0; v < G.V(); v++) {
            //如果v和s连通则打印出来
            if (search.marked(v)) {
                System.out.print(" " + v);
            }
        }
        System.out.println();
        System.out.println(search.count());
    }
}
