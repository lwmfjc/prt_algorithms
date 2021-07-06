package com.ly.ch2;

import edu.princeton.cs.algs4.In;

public class MergeBU extends BaseSort {
    private static Comparable[] aux;//归并所需的辅助数组

    /**
     * 将已排序的a[lo]..a[mid]和已排序
     * 的a[mid+1]...a[hi]进行归并
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a,
                             int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
            //将数组lo-->hi的值拷贝到辅助数组
        }

        //注意这个循环,数组长度决定了比较次数
        //这里称lo->mid为左元素,j->hi为右元素
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                //如果左元素大于mid,即左元素提取完了,
                //则直接将右元素拷过去
                a[k] = aux[j++];
            } else if (j > hi) {
                //如果右元素大于hi,即右元素提取完了,
                //则直接将左元素拷过去
                a[k]=aux[i++];
            }else if(less(aux[j],aux[i])){
                //如果右元素小于左元素,
                //则拷贝右元素
                a[k]=aux[j++];
            }else {
                //如果左元素小于右元素,
                //则拷贝左元素
                a[k]=aux[i++];
            }
        }
    }
    public static void sort(Comparable[] a){
        //进行lgN 次两两归并
        int N=a.length;
        aux=new Comparable[N];
        for(int sz=1;sz<N;sz=sz+sz){//sz=1,2,4,8,16...子数组大小
            for(int lo=0;lo<N-sz;lo+=sz+sz){//lo 子数组索引
                //这里使用min是因为最后一个数组长度不一定足够大小
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
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
