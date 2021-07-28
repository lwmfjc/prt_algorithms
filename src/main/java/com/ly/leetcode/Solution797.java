package com.ly.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Solution797 {
    private boolean[] marked;//是否标记过
    ArrayList<List<Integer>> arrayList = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        marked = new boolean[graph.length];
        for (int s = 0; s < graph.length; s++) {
            if (!marked[s]) {
                List<Integer> array = new ArrayList<>();
                array.add(s);
                arrayList.add(array);
                dfs(graph, s);
            }
        }
        return arrayList;
    }

    private void dfs(int[][] graph, int v) {
        marked[v] = true;//标记v
        for (int w : graph[v]) {
            if (!marked[w]) {
                arrayList.get(arrayList.size() - 1)
                        .add(w);
                dfs(graph, w);
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2}, {3}, {3}, {}};
        Solution797 solution797 = new Solution797();
        List<List<Integer>> lists = solution797.allPathsSourceTarget(a);
        for (int i = 0; i < lists.size(); i++) {
            for (int j : lists.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}
