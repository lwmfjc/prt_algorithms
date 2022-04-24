package com.ly.recusive;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public abstract class BaseSort {

    protected static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    protected static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            //判断后面的数是不是比前面的小
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }
}
