package com.ly.ch2_exp;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class Quick extends BaseSort {
    /**
     * 排序
     *
     * @param a
     * @param lo
     * @param hi
     */
    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j);
        sort(a, j + 1, hi);
    }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);//打乱
        sort(a, 0, a.length - 1);
    }

    //进行切割
    public static int partition(Comparable[] a, int lo, int hi) {
        int i=lo;
        int j=hi+1;
        while (true) {//不断循环
            while (isLess(a[++i], a[lo])) {
                if (i == hi) {
                    break;
                }
            }
            while (isLess(a[lo], a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i>=j){
                break;
            }
            exch(a,i,j);
        }
        exch(a,j,lo);
        return j;
    }

    public static void main(String[] args) {
        String[] a= In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
