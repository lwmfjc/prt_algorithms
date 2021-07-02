package com.ly.ch2;

import edu.princeton.cs.algs4.StdOut;

public class BaseSort {

    protected static void exch(Comparable[] a, int v, int w) {
        Comparable temp=a[v];
        a[v]=a[w];
        a[w]=temp;
    }

    protected static boolean less(Comparable v, Comparable w) {
        //v是否小于w
        return v.compareTo(w)<0;
    }
    protected static void show(Comparable[] a){
        for(int i=0;i<a.length;i++){
            StdOut.print(a[i]+" ");
        }
        StdOut.println();
    }
    public static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }
}
