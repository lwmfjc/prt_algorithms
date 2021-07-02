package com.ly.ch2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Selection extends BaseSort {
    /**
     * 看代码,只移动n次,
     * 但是比较了(n-1)+(n-2)+...1=(n-1)*n/2~ n^n/2
     * @param a
     */
    public static void sort(Comparable[] a){
        int N=a.length;
        for(int i=0;i<N;i++){
            int min=i;
            //经过一轮后把n个数,n-1个数,n-2个数...1个数
            //跟这轮中最小值比较
            for(int j=i+1;j<N;j++){
                if(less(a[j],a[min])){
                    min=j;
                }
            }
            //找到最小值后将最小值左移
            exch(a,i,min);
        }
    }

    public static void main(String[] args) {
        String[] a= In.readStrings();
        sort(a);
        //-ea 断言 已经排序则继续输出
        assert isSorted(a);
        show(a);
    }

}
