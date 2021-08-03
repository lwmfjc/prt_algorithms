package com.ly.ch4_exp4;

import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;

public class Main {
    public static void main(String[] args) {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(
                new In(args[0])
        );
        DijkstraSP sp = new DijkstraSP(G, 0);
        for (int v = 0; v < G.V(); v++) {
            System.out.print(v + ":");
            if(sp.pathTo(v)!=null) {
                for (DirectedEdge e :
                        sp.pathTo(v)) {
                    System.out.print(e + " ");
                }
            }
            System.out.println();
        }

    }
}
