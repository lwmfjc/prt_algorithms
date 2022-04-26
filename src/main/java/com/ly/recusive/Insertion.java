package com.ly.recusive;

import edu.princeton.cs.algs4.StdIn;

public class Insertion extends BaseSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        //将下表为 n-1的数，依次和n-2,n-3一直到0比较，
        //所以第二层for只走到1，因为0前面没有值
        //如果比前面的值小，就进行交换
        for (int i = 1; i < N; i++) {
            /*for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)*/
            for (int j = i; j >=1 && less(a[j], a[j - 1]); j--){
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readStrings();
        sort(a);
        if (isSorted(a)) {
            show(a);
        }
    }
}
