package com.ly.leetcode;

/**
 * 二分图解法
 */
public class Solution785 {
    private boolean[] color;//两个集合,true 和false
    private boolean[] marked;//标记是否标记(遍历)过
    private boolean isTowColorable = true;

    public boolean isBipartite(int[][] graph) {
        color = new boolean[graph.length];
        marked = new boolean[graph.length];
        for (int s = 0; s < graph.length; s++) {
            if (!marked[s]) {
                dfs(graph, s);
                if (!isTowColorable) {
                    return false;
                }
            }
        }
        return isTowColorable;
    }

    private void dfs(int[][] graph, int v) {
        marked[v] = true;
        for (int w : graph[v]) {
            if (!marked[w]) {
                //给邻接点着色
                color[w] = !color[v];
                dfs(graph, w);
            } else if (color[w] == color[v]) {
                //连上了一个标记过的顶点且两个顶点颜色一样
                isTowColorable = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution785 solution785 = new Solution785();
        int[][] G = new int[][]{{1}, {0, 3}, {3}, {1, 2}};
        System.out.println(solution785.isBipartite(G));
    }
}
