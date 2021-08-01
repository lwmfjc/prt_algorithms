package com.ly.ch4_exp1;

import com.ly.ch1.Queue;
import edu.princeton.cs.algs4.In;

public class BreathFirstSearch {
    private boolean[] marked;
    private int count;//连通分量个数

    public BreathFirstSearch(Graph G) {
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                count++;
                bfs(G, v);
                System.out.println();
            }
        }
    }

    public void bfs(Graph G, int v) {
        Queue<Integer>  queue=new Queue<>();
        queue.enqueue(v);
        marked[v]=true;
        while (!queue.isEmpty()) {
            int x = queue.dequeue();
            System.out.print(x+" ");
            for (int w : G.adj(x)) {
                if (!marked[w]) {//如果w没有遍历过
                    marked[w]=true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        BreathFirstSearch search = new BreathFirstSearch(G);
        System.out.println(search.count());
    }
}
