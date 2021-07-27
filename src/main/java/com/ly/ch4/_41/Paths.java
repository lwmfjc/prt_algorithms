package com.ly.ch4._41;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Paths {
    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        DepthFirstPaths search =
                new DepthFirstPaths(G, s);
        System.out.println();
        for (int v = 0; v < G.V(); v++) {
            //从v到s
            StdOut.print(s + " to  " + v + ": ");
            if (search.hasPathTo(v)) {
                //找到s到v的路径
                for (int x : search.pathTo(v)) {
                    if (x == s) {
                        StdOut.print(x);
                    } else {
                        StdOut.print("-" + x);
                    }
                }
            }
            StdOut.println();
        }
    }
}
