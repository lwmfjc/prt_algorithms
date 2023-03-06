package com.ly.ch2_exp;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;

public class MaxPQIndex {

    private int N;
    private int[] matrix;
    private int[] indexes;

    /**
     * n代表总共有几个数
     *
     * @param n
     */
    public MaxPQIndex(int n) {
        matrix = new int[n + 1];
        indexes = new int[n + 1];
        for (int i = 1; i < indexes.length; i++) {
            indexes[i] = i;
        }
    }
}
