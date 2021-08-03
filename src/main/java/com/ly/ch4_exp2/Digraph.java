package com.ly.ch4_exp2;

import com.ly.ch1.Bag;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }

    }

    public Digraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int e = 0; e < E; e++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int E() {
        return E;
    }

    public int V() {
        return V;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);//由v指向w
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        String s = "Digraph{" + "vertex nums[" +
                V +
                "]--edge nums[" + E + "]}\n";
        for (int v = 0; v < V; v++) {
            s += v + ":";
            for (int w : adj(v)) {
                s += "->" + w + " ";
            }
            s += "\n";
        }
        return s;
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V(); v++) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }


    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));
        Digraph G1 = G.reverse();
        System.out.println(G1);
    }
}
