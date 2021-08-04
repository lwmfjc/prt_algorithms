package com.ly.leetcode;

import java.util.PriorityQueue;

public class Solution1584 {
    //横切边 默认是最小堆
    private PriorityQueue<Edge> pq = new PriorityQueue();
    private int minDistance;

    private class Edge implements Comparable<Edge> {
        private int v;
        private int w;
        private double weight;

        public Edge(int v, int w, double weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        public double weight() {
            return weight;
        }

        public int either() {
            return v;
        }

        public int other(int v) {
            if (v == this.v) {
                return w;
            } else {
                return v;
            }
        }

        @Override
        public int compareTo(Edge o) {
            if (this.weight < o.weight) {
                return -1;
            } else if (o.weight < this.weight) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    private int V;//顶点数

    private boolean[] marked;

    public int minCostConnectPoints(int[][] points) {
        V = points.length;
        if (V < 1) return 0;

        marked = new boolean[V];
        visit(points, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]) continue;
            minDistance += e.weight();
            if (!marked[v]) visit(points, v);
            if (!marked[w]) visit(points, w);
        }
        return minDistance;

    }

    private void visit(int[][] points, int v) {
        marked[v] = true;//标记顶点v已经访问过了
        for (int w = 0; w < V; w++) {
            if (w == v || marked[w]) {
                continue;
            }
            pq.offer(new Edge(v, w, Math.abs(points[v][0] - points[w][0]) +
                    Math.abs(points[v][1] - points[w][1])));
        }

    }


    public static void main(String[] args) {
        Solution1584 solution1584 = new Solution1584();
        int[][] a1 = new int[][]{{0, 0}, {1, 1}, {1, 0}, {-1, 1}};
        int[][] a = new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(a[4][1]);
        System.out.println(solution1584.minCostConnectPoints(a));
    }
}
