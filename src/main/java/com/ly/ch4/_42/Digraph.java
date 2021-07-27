package com.ly.ch4._42;

import com.ly.ch1.Bag;
import com.ly.ch4._41.Graph;
import edu.princeton.cs.algs4.In;

public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
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

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /**
     * 让v指向w
     *
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * 将有向图反向
     *
     * @return
     */
    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            //v指向的顶点反过来指向v
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }

    @Override
    public String toString() {
        String s = "Vertex num[" + V + "]--[" +
                "Edge num[" + E + "]\n";
        for (int v = 0; v < V(); v++) {
            s += v + ": ";
            for (int w : adj(v)) {
                s += "-->" + w + " ";
            }
            s+="\n";
        }
        return s;
    }

    public static void main(String[] args) {
        Digraph digraph = new Digraph(new In(args[0]));
        System.out.println(digraph);
    }
}
