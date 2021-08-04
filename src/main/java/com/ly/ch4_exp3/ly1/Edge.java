package com.ly.ch4_exp3.ly1;

public class Edge implements Comparable<Edge> {
    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertext) {
        if (vertext == v) {
            return w;
        } else {
            return v;
        }
    }

    public double weight() {
        return weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight(), o.weight());
    }
}
