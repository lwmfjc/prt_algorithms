package com.ly.ch2_exp;

import edu.princeton.cs.algs4.In;

public class PQSort extends BaseSort {
    public static void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a, j, j + 1)) {
                j++;
            }
            //j是子节点,如果父节点k没有小于j, 则退出循环
            if (!less(a, k, j)) {
                break;
            }
            exch(a, j, k);
            k = j;
        }
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    public static void sort(Comparable[] a) {
        int N = a.length - 1;
        for (int k = N / 2; k >= 1; k--) {
            //下沉建立堆
            sink(a, k, N);
        }
        while (N > 1) {
            exch(a, N--, 1);
            sink(a, 1, N);
        }
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
