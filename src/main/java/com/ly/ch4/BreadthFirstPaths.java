package com.ly.ch4;

import edu.princeton.cs.algs4.Queue;

import java.util.Stack;

/**
 * 广度优先搜索路径
 * 通过edgeTo数组知道某顶点的上一个顶点是哪个
 * 通过marked数组知道某顶点是否已经被标记
 * 通过stack后进先出的原理,得到从s->的路径
 */
public class BreadthFirstPaths {
    private boolean[] marked;//到达该顶点的最短路径已知吗
    private int[] edgeTo;//到达该顶点(数组下标)的已知路径上的最后一个顶点
    private final int s;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];//数组下标表示某顶点,值表示
        //连接该顶点的最后一个顶点
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                edgeTo[w] = v;//保存最短路径的最后一条边
                marked[w] = true;//标记它,最短路径已知
                queue.enqueue(w); //添加到队列中,等下用来查找接下来的路径
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * s->v的路径
     * @param v
     * @return
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

}
