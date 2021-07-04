package com.ly.ch2_exp;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

/**
 * 选择排序
 */
public class SelectionSort extends BaseSort {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min=i;
            for (int j = i + 1; j < a.length; j++) {
                if(isLess(a[j],a[min])){
                    min=j;
                }
            }
            exch(a,min,i);
        }
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);

    }
}
