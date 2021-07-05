package com.ly.ch2;

import edu.princeton.cs.algs4.In;

public class Insertion extends BaseSort {
    /**
     * 这里进行了改进 exch方法非常消耗性能,改了之后快了200倍
     * @param a
     */
    public static void sort(Comparable[] a){
        int N=a.length;
        for(int i=1;i<N;i++){
            int j=i;
            Comparable temp=a[j];
            //如果
            while (j>0&&less(a[j],a[j-1])){
                a[j]=a[j-1];
                j--;
            }
            a[j]=temp;
        }
    }
    public static void sort2(Comparable[] a){
        int N=a.length;
        for(int i=1;i<N;i++){
            //将a[i]插入到a[i-1],a[i-2],a[i-3]...之中
            //不断将最后一个数往左移
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
    }
    public static void sort1(Comparable[] a) {
        int n = a.length;

        // put smallest element in position to serve as sentinel
        int exchanges = 0;
        for (int i = n-1; i > 0; i--) {
            if (less(a[i], a[i-1])) {
                exch(a, i, i-1);
                exchanges++;
            }
        }
        if (exchanges == 0) return;


        // insertion sort with half-exchanges
        for (int i = 2; i < n; i++) {
            Comparable v = a[i];
            int j = i;
            while (less(v, a[j-1])) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = v;
        }


    }
    public static void main(String[] args) {
        String[] a= In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
