package com.ly.ch4_exp1;

import com.ly.ch1.Stack;
import edu.princeton.cs.algs4.In;

public class DepthFirstPath {
    private boolean[] marked;//标记
    private int[] edgeTo;//起点到已知路径上的最后一个顶点
    private final int s;//起点

    public DepthFirstPath(Graph G, int s) {
        this.s = s;
        marked=new boolean[G.V()];
        edgeTo=new int[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
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
        DepthFirstPath search = new DepthFirstPath(G, s);
        for (int i = 0; i < G.V(); i++) {
            Iterable<Integer> iterable= search.pathTo(i);
            if(iterable!=null) {
                System.out.print(s + "->" + i + ":");
                for (int w : iterable) {
                    System.out.print(w + " ");
                }
                System.out.println();
            }
        }
    }
}
