package com.ly.ch4_exp1;

import edu.princeton.cs.algs4.In;

/**
 * 使用深度优先搜索处理连通分量问题
 */
public class CC {
    private boolean[] marked;
    private int count;//连通分量数
    private int[] id;

    public CC(Graph G) {
        id = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                count++;
                dfs(G, v);
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        CC cc = new CC(G);
        for (int v = 0; v < G.V(); v++) {
            System.out.println(v + "->id:" + cc.id(v));
        }

    }
}
