package com.ly.ch4_exp4;

import com.ly.ch1.Bag;
import com.ly.ch4_exp3.Edge;

//有向边
public class DirectedEdge implements Comparable<DirectedEdge> {
    private final int v;
    private final int w;
    private double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double weight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("Edge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=%.2f }", weight);
    }

    @Override
    public int compareTo(DirectedEdge o) {
        if (this.weight() < o.weight()) {
            return -1;
        } else if (this.weight() > o.weight()) {
            return 1;
        } else {
            return 0;
        }
    }
}
