package com.ly.ch4_exp2;

import com.ly.ch1.Queue;
import com.ly.ch1.Stack;
import edu.princeton.cs.algs4.In;

/**
 * 有向图的广度优先查找
 */
public class DirectedBFS {
    private final int s;
    private boolean[] marked;
    private int[] pathTo;//这个可以用来记录每个顶点的上一个顶点,是因为【★同一个顶点只会被访问过一次】


    public DirectedBFS(Digraph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        pathTo = new int[G.V()];

                bfs(G, s);

    }

    private void bfs(Digraph G, int v) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);
        marked[v] = true;
        while (!queue.isEmpty()) {
            int x = queue.dequeue();
            for (int w : G.adj(x)) {
                if (!marked[w]) {
                    marked[w] = true;
                    pathTo[w] = x;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int x = v; x != s; x = pathTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));
        int s = 0;
        DirectedBFS bfs = new DirectedBFS(G, s);
        for (int v = 0; v < G.V(); v++) {
            System.out.print(s + "->" + v);
            Iterable<Integer> integers = bfs.pathTo(v);
            if (integers != null) {
                System.out.print(":");
                for (int w : integers) {
                    System.out.print("->" + w);
                }
            }
            System.out.println();
        }
    }
}
