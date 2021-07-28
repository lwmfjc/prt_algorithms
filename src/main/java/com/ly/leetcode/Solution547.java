package com.ly.leetcode;

public class Solution547 {
    private boolean[] marked;//标记过

    private void dfs(int[][] graph, int v) {
        marked[v] = true;
        for (int w = 0; w < graph[v].length; w++) {
            if (graph[v][w] == 1 && !marked[w]) {
                dfs(graph, w);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        marked = new boolean[isConnected.length];
        int count = 0;
        for (int s = 0; s < isConnected.length; s++) {
            if (!marked[s]) {
                count++;
                dfs(isConnected, s);
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
