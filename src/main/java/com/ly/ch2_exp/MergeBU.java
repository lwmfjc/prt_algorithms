package com.ly.ch2_exp;

import edu.princeton.cs.algs4.In;

public class MergeBU extends BaseSort {
    private static Comparable[] aux;//临时数组

    /**
     * 将两个已排序的数组进行归并(排序合并)
     *
     * @param a
     * @param lo
     * @param mid
     * @param high
     */
    public static void merge(Comparable[] a,
                             int lo, int mid, int high) {
        //lo=0,mid=0,high=1
        //i=0,mid=0,j=1
        if (aux != null) {
            int i = lo;
            int j = mid + 1;
            //拷贝数组值到临时数组
            for (int k = i; k <= high; k++) {
                aux[k] = a[k];
            }
            for (int k = i; k <= high; k++) {
                if (i > mid) {
                    a[k] = aux[j++];
                } else if (j > high) {
                    a[k] = aux[i++];
                } else if (isLess(aux[i], aux[j])) {
                    a[k] = aux[i++];
                } else {
                    a[k] = aux[j++];
                }
            }
        }
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        //对整个数组进行排序
        sort(a, 0, a.length - 1);
    }

    /**
     * 递归排序
     *
     * @param a
     * @param lo
     * @param high
     */
    private static void sort(Comparable[] a, int lo, int high) {
        //不需要排序
        if (lo >= high) {
            return;
        }
        //N每次+N
        //1,2,4,8,16...
        for (int N = 1; N < a.length; N += N) {
            for (int i = 0; i < a.length - N; i += N+N) {
                merge(a, i, i + N - 1, Math.min(i + N + N - 1, a.length - 1));
            }
        }
    }

    public static void main(String[] args) {
        String[] a= In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
