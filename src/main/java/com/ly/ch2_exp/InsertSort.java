package com.ly.ch2_exp;

import edu.princeton.cs.algs4.In;

public class InsertSort extends BaseSort {
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for(int j=i;j>0&&isLess(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
    }
    public static void sort1(Comparable[] a){
        for(int i=1;i<a.length;i++){
            int tempi=i;
            Comparable temp=a[tempi];
            //如果当前值应该在前一个值前面,那就把前一个值往后移
            while (tempi>0&&isLess(temp,a[tempi-1])){
                a[tempi]=a[tempi-1];
                tempi--;
            }
            a[tempi]=temp;
        }
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort1(a);
        assert isSorted(a);
        show(a);
    }
}
