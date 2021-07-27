package com.ly.ch4._41;
//深度优先搜索
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;//当前节点搜索过了
        System.out.printf("%3d", v);
        count++;
        for (int w : G.adj(v)) {
            //如果w没有搜索过,那就继续搜索
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
}
