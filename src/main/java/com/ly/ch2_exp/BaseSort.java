package com.ly.ch2_exp;

public class BaseSort {
    public static void exch(Comparable[] a, int m, int n) {
        Comparable temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }

    /**
     * 判断m是否小于n
     *
     * @param m
     * @param n
     * @return
     */
    public static boolean isLess(Comparable m, Comparable n) {
        return m.compareTo(n) < 0;
    }

    /**
     * 显示数组元素
     *
     * @param a
     */
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%3s", a[i]);
        }
        System.out.println();
    }

    /**
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (isLess(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

}
