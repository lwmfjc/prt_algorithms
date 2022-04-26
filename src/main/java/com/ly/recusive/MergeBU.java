package com.ly.recusive;

import edu.princeton.cs.algs4.StdIn;

public class MergeBU extends BaseSort {
    private static Comparable[] aux;

    private static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        //每次合并的子数组长度翻倍
        for (int sz = 1; sz < N; sz = sz + sz) {
            //lo:子数组索引
            //下面改写了一下，比较好理解
            //边界问题，这里要保证最后一组子数组的前一个元素下标，能再放一组sz长度的子数组，即小数组的下标刚好等于(N-1)-sz
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                //循环合并一个个的小数组
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
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
