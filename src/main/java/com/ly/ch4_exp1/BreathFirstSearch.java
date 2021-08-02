package com.ly.ch4_exp1;

import com.ly.ch1.Queue;
import edu.princeton.cs.algs4.In;

public class BreathFirstSearch {
    private boolean[] marked;//是否已经标记
    private final int s;//源点

    public BreathFirstSearch(Graph G, int s) {
        this.s = s;
        marked=new boolean[G.V()];
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<>();//队列
        queue.enqueue(s);
        marked[s] = true;
        System.out.print (s+" ");
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                if(!marked[w]) {
                    System.out.print (w+" ");
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph G=new Graph(new In(args[0]));
        int s=Integer.parseInt(args[1]);
        BreathFirstSearch search=new BreathFirstSearch(G,s);


    }
}
