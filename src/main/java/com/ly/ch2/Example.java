package com.ly.ch2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Example extends BaseSort {
    /**
     * 看代码,只移动n次,
     * 但是比较了(n-1)+(n-2)+...1=(n-1)*n/2~ n^n/2
     * @param a
     */
    public static void sort(Comparable[] a) {

    }

    public static void main(String[] args) {
        String[] a= In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
