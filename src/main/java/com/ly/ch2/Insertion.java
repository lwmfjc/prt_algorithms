package com.ly.ch2;

import edu.princeton.cs.algs4.In;

public class Insertion extends BaseSort {
    public static void sort(Comparable[] a){
        int N=a.length;
        for(int i=1;i<N;i++){
            //将a[i]插入到a[i-1],a[i-2],a[i-3]...之中
            //不断将最后一个数往左移
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
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
