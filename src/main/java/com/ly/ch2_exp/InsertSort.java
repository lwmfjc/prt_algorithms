package com.ly.ch2_exp;

import edu.princeton.cs.algs4.In;

public class InsertSort extends BaseSort {
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for(int j=i;j>0&&isLess(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
