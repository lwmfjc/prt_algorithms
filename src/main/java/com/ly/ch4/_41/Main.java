package com.ly.ch4._41;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Main {
    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        System.out.println(G);
        StdOut.println("-----------------");
        int s = Integer.parseInt(args[1]);
        DepthFirstSearch
                search = new DepthFirstSearch(G, s);
        //搜索和s相连的所有节点个数
        /*for (int v = 0; v < G.V(); v++) {
            if (search.marked(v)) {
                StdOut.print(v + " ");
            }
        }*/
        StdOut.println("-----------------");
        if (search.count() != G.V()) {
            StdOut.print("NOT ");
        }
        StdOut.println("connected");
    }
}
