package com.ly.ch4_exp;

import com.ly.ch4._42.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class DeathFirstDirectedPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DeathFirstDirectedPaths(Digraph digraph, int s) {
        marked = new boolean[digraph.V()];
        edgeTo = new int[digraph.V()];
        this.s = s;
        // dfs(digraph, s);
         bfs(digraph, s);
    }

    //深度查找
    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
       // System.out.print(v + " ");
        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(digraph, w);
            }
        }
    }

    //广度查找
    private void bfs(Digraph digraph, int v) {
        Queue<Integer> queue = new Queue();
        queue.enqueue(v);
        marked[v] = true;
        while (!queue.isEmpty()) {
            int x = queue.dequeue();
            //System.out.print(x + " ");
            for (int w : digraph.adj(x)) {
                if (!marked[w]) {
                    edgeTo[w]=x;
                    queue.enqueue(w);
                    marked[w] = true;
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * 到v的路径
     *
     * @param v
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int x = v; x!= s; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }

    public static void main(String[] args) {
        Digraph digraph = new Digraph(new In(args[0]));//构造图
        int s = Integer.parseInt(args[1]);
        DeathFirstDirectedPaths paths = new DeathFirstDirectedPaths(digraph, s);
        for (int v : paths.pathTo(2)) {
            System.out.print(v + " ");
        }
    }
}
