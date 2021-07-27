package com.ly.ch4_exp;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * 深度优先路径
 */
public class DepthFirstPaths {
    private int s;//搜索的顶点
    private boolean[] marked;//是否标记
    private int[] edgeTo;//标记到当前顶点(数组下标)的最后一条路径(最后一个顶点)
    private int count;//路径上共有几个顶点

    public DepthFirstPaths(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;//标记当前节点被搜索了
        // System.out.print(v + " ");
        //搜索相邻结点
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;//顶点w的上一个顶点是v
                dfs(G, w);
            }
        }
    }

    private boolean marked(int v) {
        return marked[v];
    }

    //s到v是否有路径
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        DepthFirstPaths paths = new DepthFirstPaths(G, s);
        for (int i : paths.pathTo(1)) {
            System.out.print(i + " ");
        }
    }
}
