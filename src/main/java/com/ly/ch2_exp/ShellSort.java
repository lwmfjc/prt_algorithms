package com.ly.ch2_exp;

import edu.princeton.cs.algs4.In;

public class ShellSort extends BaseSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        //这里h一定要大于N/3
        while (h < N / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && isLess(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        String[] a= In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
