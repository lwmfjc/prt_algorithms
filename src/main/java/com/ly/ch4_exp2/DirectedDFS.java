package com.ly.ch4_exp2;

import com.ly.ch1.Stack;
import edu.princeton.cs.algs4.In;

//有向图的深度优先搜索
public class DirectedDFS {
    private boolean[] marked;
    private final int s;//源点
    private int[] pathTo;//路径


    public DirectedDFS(Digraph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        pathTo = new int[G.V()];
        dfs(G, s);
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                pathTo[w] = v;//标记w的上一个顶点为v
                dfs(G, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!marked[v]) return null;//如果没连通则返回空值
        Stack<Integer> stack = new Stack<>();
        for (int x = v; x != s; x = pathTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }

    public static void main(String[] args) {
        Digraph digraph = new Digraph(new In(args[0]));
        DirectedDFS dfs = new DirectedDFS(digraph, 0);
        for (int v = 0; v < digraph.V(); v++) {
            Iterable<Integer> integers = dfs.pathTo(v);
            System.out.print(v + ":");
            if (integers != null) {
                for (int i : integers) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }


}
