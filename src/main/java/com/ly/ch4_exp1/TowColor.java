package com.ly.ch4_exp1;

import edu.princeton.cs.algs4.In;

/**
 * 使用深度优先遍历处理二分图的问题
 */
public class TowColor {
    private boolean[] marked;
    private boolean isTwoColorable=true;
    private boolean[] color;

    public TowColor(Graph G) {
        marked = new boolean[G.V()];
        color=new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v );
            }
        }
    }

    private void dfs(Graph G, int v ) {
        marked[v] = true;
        System.out.print(v+" ");
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(G, w );
            } else if (color[w]==color[v]) {//如果标记过且这个结点不是刚访问过的顶点,说明和另一个顶点形成了环
                isTwoColorable = false;
            }
        }
    }

    public boolean isTwoColorable() {
        return isTwoColorable;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        System.out.println(G);
        System.out.println();
        TowColor cycle = new TowColor(G);
        System.out.println(cycle.isTwoColorable());
    }
}
