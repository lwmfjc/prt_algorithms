package com.ly.ch4_exp1;

import com.ly.ch1.Queue;
import com.ly.ch1.Stack;
import edu.princeton.cs.algs4.In;

public class BreathFirstPath {
    private boolean[] marked;//是否已经标记
    private final int s;//源点
    private int[] pathTo;//索引i的上一个顶点为v(v为数组值)

    public BreathFirstPath(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        pathTo=new int[G.V()];
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<>();//队列
        queue.enqueue(s);
        marked[s] = true;
        System.out.print(s + " ");
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    pathTo[w] = v;
                    System.out.print(w + " ");
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        Stack<Integer> stack = new Stack<>();
        if (!hasPathTo(v)) {
            return null;
        }
        for (int x = v; x != s; x = pathTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;

    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        BreathFirstPath search = new BreathFirstPath(G, s);
        System.out.println();
        for(int v=0;v<G.V();v++) {
            if (search.pathTo(v)!=null){
                for(int w:search.pathTo(v)){
                    System.out.print(w+" ");
                }
                System.out.println();
            }
        }

    }
}
