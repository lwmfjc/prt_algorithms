package com.ly.ch4_exp1;

import edu.princeton.cs.algs4.In;

/**
 * 使用深度优先遍历处理环的问题
 */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked=new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v, v);
            }
        }
    }

    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                marked[w] = true;
                dfs(G, w, v);
            } else if (u != w) {//如果标记过且这个结点不是刚访问过的顶点,说明和另一个顶点形成了环
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        Cycle cycle = new Cycle(G);
        System.out.println(cycle.hasCycle());
    }
}
