package com.ly.ch2_exp;

import edu.princeton.cs.algs4.In;

import java.math.BigInteger;

/**
 * 归并排序
 */
public class Merge extends BaseSort {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        //如果只有一个元素则不需要归并
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    /**
     * 将数组两部分归并,前提是这两部分是各自有序的
     *
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        BigInteger bigInteger=BigInteger.valueOf(12);

        int j = mid + 1;
        int i = lo;
        for (int k = i; k <= hi; k++) {
            aux[k] = a[k];
        }
        //对a[lo]..a[hi]之间的数据进行排序
        for (int k = i; k <= hi; k++) {
            if (j > hi) {
                a[k] = aux[i++];
            } else if (i > mid) {
                a[k] = aux[j++];
            } else if (isLess(aux[i], aux[j])) {
                //只有数组间的比较才计入比较次数
                //将较小的值取出来放上去
                a[k] = aux[i++];
            } else {
                //只有数组间的比较才计入比较次数
                //如果a[j]min>a[i]max,那么只需要一半的比较次数
                a[k] = aux[j++];
            }
        }
    }
    public static void main(String[] args){
        String[] a= In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
