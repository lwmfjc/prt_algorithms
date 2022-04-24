package com.ly.recusive;

import edu.princeton.cs.algs4.In;

public class Selection extends BaseSort {

    protected static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            //从i往右找最小的值，放到最左边
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a):"未进行排序";
        show(a);
    }
}
