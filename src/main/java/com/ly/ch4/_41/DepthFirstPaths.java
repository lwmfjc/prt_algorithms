package com.ly.ch4._41;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 广度优先搜索路径
 */
public class DepthFirstPaths {
    private boolean[] marked;
    private int count;//路径上有多少个顶点
    private int[] edgeTo;//从起点到一个顶点的已知路径上的最后一个顶点
    private final int s;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
        System.out.println("\n-----------");
    }

    /**
     * 深度搜索
     * @param G
     * @param v
     */
    private void dfs(Graph G, int v) {
        marked[v] = true;//当前节点搜索过了
        System.out.printf("%3d", v);
        count++;
        for (int w : G.adj(v)) {
            //如果w没有搜索过,那就继续搜索
            if (!marked[w]) {
                //w的上一个结点是v
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    /**
     * 是否标记
     * @param w
     * @return
     */
    public boolean marked(int w) {
        return marked[w];
    }

    /**
     * 路径上结点总数
     * @return
     */
    public int count() {
        return count;
    }

    /**
     * 是否有路径
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    //使用递归打印s->的路径
    public void print(int v) {
        if (v == s) {
            StdOut.print(v + " ");
            return;
        }
        //不存在路径则不打印
        if (!hasPathTo(v)) {
            System.out.println("不存在路径");
            return;
        }

        //打印v的上一个结点
        print(edgeTo[v]);
        StdOut.print(v + " ");
    }

    //查找s到v的路径
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        //edgeTo[x]得到x的上一个结点,即处理
        //v的上一个结点,直到遍历到上一个结点是s则
        // 停止遍历
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        //使用参数0的文件构建一个图
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        DepthFirstPaths paths=new
                DepthFirstPaths(G,s);
        paths.print(5);
    }
}
