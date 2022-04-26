package com.ly.recusive;

import edu.princeton.cs.algs4.StdIn;

public class Merge extends BaseSort {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];//辅助数组，一次性分配空间
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        //保证左边有序
        sort(a, lo, mid);
        //保证右边有序
        sort(a, mid + 1, hi);
        //归并数组有序的两部分
        merge(a, lo, mid, hi);
    }

    /**
     * 这里有一个前提，就是a[i..mid]是有序的，
     * a[mid..hi]是有序的
     *
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a,
                             int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        //先在辅助数组赋上需要的值
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                //说明i(左边）比较完了，直接拿右边的值放进去
                a[k] = aux[j++];
            } else if (j > hi) {
                //说明j(右边)比较完了，直接拿左边的值放进去
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                //左右都还有值的情况下，取出最小的值放进去
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        String[] lyin = StdIn.readStrings();
        sort(lyin);
        if (isSorted(lyin)) {
            show(lyin);
        }
    }
}
