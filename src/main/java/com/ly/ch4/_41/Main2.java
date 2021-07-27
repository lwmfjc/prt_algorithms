package com.ly.ch4._41;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.In;

public class Main2 {
    public static void main(String[] args) {
        edu.princeton.cs.algs4.Graph G = new
                edu.princeton.cs.algs4.Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        BreadthFirstPaths paths=new
                BreadthFirstPaths(G,3);

    }
}
