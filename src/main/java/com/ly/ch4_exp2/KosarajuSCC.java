package com.ly.ch4_exp2;

import com.ly.ch4_exp1.Graph;
import edu.princeton.cs.algs4.In;

/**
 * 使用深度优先搜索处理连通分量问题
 */
public class KosarajuSCC {
    private boolean[] marked;
    private int[] id;
    private int count;//连通分量数

    public KosarajuSCC(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order=new DepthFirstOrder(G.reverse());
        for (int v:order.reversePost()) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));
        System.out.println(G);
        System.out.println("--------------");
        KosarajuSCC cc = new KosarajuSCC(G);
        for (int v = 0; v < G.V(); v++) {
            System.out.println(v + "->id:" + cc.id(v));
        }

    }
}
