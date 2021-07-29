package com.ly.ch4._42;


import edu.princeton.cs.algs4.StdOut;

//拓扑排序
public class Topological {
    private Iterable<Integer> order;//顶点的拓扑顺序

    public Topological(Digraph G) {
        DirectedCycle cycle = new DirectedCycle(G);
        if (!cycle.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }

    public static void main(String[] args) {
        String filename = args[0];
        String separator = args[1];
        SymbolDigraph sg = new SymbolDigraph(filename, separator);
        Topological top = new Topological(sg.G());
        for (int v : top.order()) {
            StdOut.println(sg.name(v));
        }
    }
}
