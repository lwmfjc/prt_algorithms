package com.ly.ch2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class Quick extends BaseSort {
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi); //将数组切分(请见"快速排序的切分")
        //4,1,3,6,5,7 ,结束后j=2--- 3,1,4,6,5,7
        //3,1,4,6,5,7 ,结束后j=1----[1,3],4,6,5,7
        //此时j=1指向元素3

        // 3 左边只有一个元素 sort(a,0,[0])
        // 3 右边没有元素 sort(a,[2],1)
        sort(a, lo, j - 1);//将左半部分a[lo..j-1]排序
        sort(a, j + 1, hi);
    }

    public static void sort(Comparable[] a) {
        //StdRandom.shuffle(a);//打乱次序
        sort(a, 0, a.length - 1);
    }

    /**
     * 将数组切分为a[lo..i-1],a[i],a[i+1..hi]
     *
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;//左右扫描指针
        Comparable v=a[lo];
        while (true){
            //扫描左右,检查扫描是否结束并交换元素
            //左边只能放小于v的值
            while(less(a[++i],v)){
                if(i==hi){
                    break;
                }
            }
            //从右往左扫描, 右边只能放大于v的值
            while (less(v,a[--j])){
                if(j==lo){
                    break;
                }
            }
            //如果从右往左找到的较v小的值的下标小于
            //从左往右找到的较v5的下标,说明两指针相遇了,
            //退出排序
            if(i>=j){
                break;
            }
            exch(a,i,j);
        }
        //交换a[lo]和a[j] 的值
        //注意,这里lo不能跟a[i]交换,因为i指向的是较a大的值,交换后
        //较大的值就变到左边去了,与预期不符合
        exch(a,lo,j);
        return j;
    }

    public static void main(String[] args) {
        //  String[] a= In.readStrings();
        Integer[] a=new Integer[]{4,1,3,6,5,7};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
