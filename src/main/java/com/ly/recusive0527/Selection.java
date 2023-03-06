package com.ly.recusive0527;

import edu.princeton.cs.algs4.In;

public class Selection extends BaseSort {
    /**
     * 选择排序
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N -1; i++) {
            int min = i;
            //找出i到最后一个元素中的最小值，放到i的位置
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, min, i);
        }
    }

    public static void main(String[] args) {
        String[] a= In.readStrings();
        sort(a);
        if(isSorted(a)){
            show(a);
        }
    }

}
