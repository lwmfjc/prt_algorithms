package com.ly.ch4._42;


import edu.princeton.cs.algs4.In;

public class KosarajuSCC {
    private boolean[] marked;
    private int[] id;
    private int count;//有几个连通分量

    public KosarajuSCC(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order =
                new DepthFirstOrder(G.reverse());
        //for (int s = 0; s < G.V(); s++) {
        for (int s : order.reversePost()) {
            if (!marked[s]) {//如果没有连接过,进行连接
                dfs(G, s);
                count++;
            }
        }
    }

    /**
     * 通过深度优先查找,标记每个顶点所属的连通分量
     *
     * @param G
     * @param v
     */
    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;//连通分量的标识是从1开始的
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    /**
     * 是否连接
     * 判断两个顶点的连通分量标识是否一样即可
     *
     * @param v
     * @param w
     * @return
     */
    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    /**
     * 查找顶点的连通分量标识
     *
     * @param v
     * @return
     */
    public int id(int v) {
        return id[v];
    }

    /**
     * 有几个连通分量
     *
     * @return
     */
    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Digraph digraph = new Digraph(new In(args[0]));
        KosarajuSCC kosarajuSCC = new KosarajuSCC(digraph);
        System.out.println(kosarajuSCC.count);
    }


}
