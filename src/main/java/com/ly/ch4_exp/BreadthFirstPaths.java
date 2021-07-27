package com.ly.ch4_exp;

import com.ly.ch1.Stack;
import edu.princeton.cs.algs4.In;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths {
    private boolean[] marked;//是否已经搜索
    private int[] edgeTo;//路径
    private final int s;//从s顶点开始搜索

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.offer(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            //System.out.print(v + " ");
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.offer(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
       // System.out.println(G);
        int s = Integer.parseInt(args[1]);
        BreadthFirstPaths paths = new BreadthFirstPaths(G, s);
        for (int i : paths.pathTo(4)) {
            System.out.print(i+" ");
        }
    }

}
