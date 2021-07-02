package com.ly.ch2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Selection {
    public static void sort(Comparable[] a){
        int N=a.length;
        for(int i=0;i<N;i++){
            int min=i;
            for(int j=i+1;j<N;j++){
                if(less(a[j],a[min])){
                    min=j;
                }
            }
            exch(a,i,min);
        }
    }

    private static void exch(Comparable[] a, int i, int min) {
        Comparable temp=a[i];
        a[i]=a[min];
        a[min]=temp;
    }

    private static boolean less(Comparable v, Comparable w) {
        //v是否小于w
        return v.compareTo(w)<0;
    }
    private static void show(Comparable[] a){
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

    public static void main(String[] args) {
        String[] a= In.readStrings();
        sort(a);
        //-ea 断言 已经排序则继续输出
        assert isSorted(a);
        show(a);
    }

}
