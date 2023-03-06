package com.ly.recusive0527;

import edu.princeton.cs.algs4.In;

public class Insertion extends BaseSort {
    /**
     * 插入排序
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        for(int i=1;i<N;i++){
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
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
